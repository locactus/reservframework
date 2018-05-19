package com.mum.servlets;

import com.google.common.cache.*;
import com.mum.dao.*;
import com.mum.dto.AppointmentDTO;
import com.mum.dto.AppointmentDTOBuilder;
import com.mum.dto.BuildDirector;
import com.mum.dto.IBuilder;
import com.mum.model.Appointment;
import com.mum.pattern.iterator.IteratorRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Wenqiang on 5/19/18.
 */
public abstract class BaseTemplate  extends HttpServlet {

    protected IStaffDAO staffDao;
    protected IClientDAO clientDao;
    protected IRequestDAO requestDao;
    protected IAppointmentDAO appointmentDao;
    protected ITimeslotDAO timeslotDao;

    {
        try {
            staffDao = DataAccessFactory.createStaffDao();
            clientDao = DataAccessFactory.createClientDao();
            requestDao = DataAccessFactory.createRequestDao();
            appointmentDao = DataAccessFactory.createAppointmentDao();
            timeslotDao = DataAccessFactory.createTimeslotDao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected List<AppointmentDTO> getAll() throws SQLException {
        List<Appointment> allAppointment = appointmentDao.getAll();
        IteratorRepository iteratorRepository = new IteratorRepository(allAppointment);
        //Log all the appointment info
        while (iteratorRepository.hasNext()) {
            Appointment next = (Appointment)iteratorRepository.next();
            System.out.println(next);
        }

        return  allAppointment.stream()
                .map(appintment -> {

                    IBuilder builder = new AppointmentDTOBuilder(appintment);
                    BuildDirector director = new BuildDirector(builder);
                    director.build();
                    return ((AppointmentDTOBuilder) builder).get();
                })
                // .map(apointment -> mapToDTO(apointment))

                .collect(Collectors.toList());
    }

    LoadingCache<String, List> revitQueryCache
            = CacheBuilder.newBuilder()
            .concurrencyLevel(8)
            .expireAfterWrite(600, TimeUnit.SECONDS)
            .initialCapacity(10)
            .maximumSize(100)
            .recordStats()
            // 设置缓存的移除通知
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(RemovalNotification<Object, Object> notification) {
                    System.out.println(notification.getKey() + " is removed, cause is " + notification.getCause());
                }
            })
            // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(new CacheLoader<String, List>() {
                @Override
                public List load(String arg0) throws Exception {
                    if(arg0.equals("appoCache")){
                        System.out.println("load from db");
                        return getAll();
                    }
                    return null;
                }
            });







}
