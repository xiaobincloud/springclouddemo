package com.cloud.order;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 为了解决session共享问题
 * @author xiaobin
 * Created by xiaobin on 2017/10/11
 * Copyright (c) 2016-2019
 */
@Component
public class SerializationBeanFactoryPostProcessor implements BeanFactoryPostProcessor,Serializable {
    private static final long serialVersionUID = -6937567624506378578L;

    public static final String SERIALIZATION_ID = "345514af-ac59-3fc3-bb99-e35751f51633";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if ((beanFactory instanceof DefaultListableBeanFactory)) {
            DefaultListableBeanFactory dlbf = (DefaultListableBeanFactory) beanFactory;
            dlbf.setSerializationId(SERIALIZATION_ID);
        }
    }
}
