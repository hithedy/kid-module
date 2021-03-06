package com.xyzq.kid.logic.user.service;

import com.xyzq.kid.logic.user.bean.DemoBean;
import com.xyzq.kid.logic.user.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 范例服务
 */
@Service("demoService")
public class DemoService {
    /**
     * 范例组件
     */
    @Autowired
    private DemoBean demoBean;


    /**
     * 方法描述
     *
     * @return 返回值
     */
    public DemoEntity call() {
        return demoBean.call();
    }
}
