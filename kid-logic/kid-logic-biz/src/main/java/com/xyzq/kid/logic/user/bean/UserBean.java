package com.xyzq.kid.logic.user.bean;

import com.xyzq.kid.logic.user.common.CommonTool;
import com.xyzq.kid.logic.user.dao.DemoDAO;
import com.xyzq.kid.logic.user.dao.UserDAO;
import com.xyzq.kid.logic.user.dao.po.DemoPO;
import com.xyzq.kid.logic.user.dao.po.UserPO;
import com.xyzq.kid.logic.user.entity.DemoEntity;
import com.xyzq.kid.logic.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 这是一个范例Java逻辑功能Bean
 */
@Component
public class UserBean {
    /**
     * 范例数据库访问对象
     */
    @Autowired
    private UserDAO userDAO;


    /**
     * 根据主键查询用户信息
     * @param id 主键
     * @return
     */
    public UserEntity selectByPrimaryKey(int id) {
        UserPO userPO = userDAO.selectByPrimaryKey(id);
        return UserPOToEntity(userPO);
    }

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return userDAO.deleteByPrimaryKey(id);
    }

    /**
     * 全量新增用户信息
     * @param entity
     * @return
     */
    public int insert(UserEntity entity){
        return userDAO.insert(UserEntityToPO(entity));
    }

    /**
     * 部分新增用户信息
     * @param entity
     * @return
     */
    public int insertSelective(UserEntity entity){
        return userDAO.insertSelective(UserEntityToPO(entity));
    }

    /**
     * 选择性更新用户信息
     * @param entity
     * @return
     */
    public int updateByPrimaryKeySelective(UserEntity entity){
        return userDAO.updateByPrimaryKeySelective(UserEntityToPO(entity));
    }

    /**
     * 全量更新用户信息
     * @param entity
     * @return
     */
    public int updateByPrimaryKey(UserEntity entity){
        return userDAO.updateByPrimaryKey(UserEntityToPO(entity));
    }

    /**
     * UserPO转UserEntity
     * @param po
     * @return UserEntity
     */
    public UserEntity UserPOToEntity(UserPO po){
        if(null == po) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.id = po.getId();
        entity.mobileno = po.getMobileno();
        entity.openid = po.getOpenid();
        entity.realname = po.getRealname();
        entity.gender = po.getGender();
        entity.subscribetime = CommonTool.DataToStringYMDHMS(po.getSubscribetime());
        entity.deleted = po.getDeleted();
        entity.createtime = CommonTool.DataToStringYMDHMS(po.getCreatetime());
        entity.updatetime = CommonTool.DataToStringYMDHMS(po.getUpdatetime());
        return entity;
    }

    /**
     * UserEntity装UserPO
     * @param entity
     * @return UserPO
     */
    public UserPO UserEntityToPO(UserEntity entity){
        UserPO po = new UserPO();
        if(null != entity.id ) {
            po.setId(entity.id);
        }
        if(null != entity.mobileno) {
            po.setMobileno(entity.mobileno);
        }
        if(null != entity.openid) {
            po.setOpenid(entity.openid);
        }
        if(null != entity.realname) {
            po.setRealname(entity.realname);
        }
        if(null != entity.gender) {
            po.setGender(entity.gender);
        }
        if(null != entity.subscribetime) {
            po.setSubscribetime(CommonTool.StringToDataYMDHMS(entity.subscribetime));
        }

        if(null != entity.deleted) {
            po.setDeleted(entity.deleted);
        }
        if(null != entity.createtime) {
            po.setCreatetime(CommonTool.StringToDataYMDHMS(entity.createtime));
        }
        if(null != entity.updatetime) {
            po.setUpdatetime(CommonTool.StringToDataYMDHMS(entity.updatetime));
        }
        return po;
    }

}