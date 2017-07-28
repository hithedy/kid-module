package com.xyzq.kid.logic.ticket.bean;

import com.xyzq.kid.logic.user.common.CommonTool;
import com.xyzq.kid.logic.ticket.dao.TicketDAO;
import com.xyzq.kid.logic.ticket.dao.po.TicketPO;
import com.xyzq.kid.logic.ticket.entity.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 这是一个范例Java逻辑功能Bean
 */
@Component
public class TicketBean {
    /**
     * 范例数据库访问对象
     */
    @Autowired
    private TicketDAO ticketDAO;


    /**
     * 根据主键查下飞行票信息
     *
     * @return 返回值
     */
    public TicketEntity selectByPrimaryKey(int id) {
        TicketPO ticketPO = ticketDAO.selectByPrimaryKey(id);
        return TicketPOToEntity(ticketPO);
    }

    /**
     * 根据主键删除飞行票信息
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return ticketDAO.deleteByPrimaryKey(id);
    }

    /**
     * 全量新增飞行票信息
     * @param entity
     * @return
     */
    public int insert(TicketEntity entity){
        return ticketDAO.insert(TicketEntityToPO(entity));
    }

    /**
     * 选择性新增飞行票信息
     * @param entity
     * @return
     */
    public int insertSelective(TicketEntity entity){
        return ticketDAO.insertSelective(TicketEntityToPO(entity));
    }

    /**
     * 根据主键选择性更新飞行票信息
     * @param entity
     * @return
     */
    public int updateByPrimaryKeySelective(TicketEntity entity){
        return ticketDAO.updateByPrimaryKeySelective(TicketEntityToPO(entity));
    }

    /**
     * 根据主键全量更新飞行票信息
     * @param entity
     * @return
     */
    public int updateByPrimaryKey(TicketEntity entity){
        return ticketDAO.updateByPrimaryKey(TicketEntityToPO(entity));
    }

    /**
     * TicketPO 转化为 TicketEntity
     * @param po
     * @return TicketEntity
     */
    public TicketEntity TicketPOToEntity(TicketPO po) {
        if(null == po) {
            return null;
        }
        TicketEntity entity = new TicketEntity();
        entity.id = po.getId();
        entity.serialno = po.getSerialno();
        entity.type = po.getType();
        entity.ownermobileno = po.getOwnermobileno();
        entity.payeropenid = po.getPayeropenid();
        entity.price = po.getPrice();
        entity.expiredate = CommonTool.DataToStringYMD(po.getExpiredate());
        entity.insurance = po.getInsurance();
        entity.orderno = po.getOrderno();
        entity.status = po.getStatus();
        entity.deleted = po.getDeleted();
        entity.createtime = CommonTool.DataToStringYMDHMS(po.getCreatetime());
        entity.updatetime = CommonTool.DataToStringYMDHMS(po.getUpdatetime());
        return entity;
    }

    /**
     * TicketEntity 转化为 TicketPO
     * @param entity
     * @return TicketPO
     */
    public TicketPO TicketEntityToPO(TicketEntity entity) {
        TicketPO po = new TicketPO();
        if(null != entity.id ) {
            po.setId(entity.id);
        }
        if(null != entity.serialno)  {
            po.setSerialno(entity.serialno);
        }
        if(null != entity.type ) {
            po.setType(entity.type);
        }
        if(null != entity.ownermobileno) {
            po.setOwnermobileno(entity.ownermobileno);
        }
        if(null != entity.payeropenid) {
            po.setPayeropenid(entity.payeropenid);
        }
        if(null != entity.price) {
            po.setPrice(entity.price);
        }
        if(null != entity.expiredate) {
            po.setExpiredate(CommonTool.StringToDataYMD(entity.expiredate));
        }
        if(null != entity.insurance) {
            po.setInsurance(entity.insurance);
        }
        if(null != entity.orderno) {
         po.setOrderno(entity.orderno);
        }
        if(null != entity.status) {
         po.setStatus(entity.status);
        }
        if(null != entity.deleted ) {
            po.setDeleted(entity.deleted);
        }
//        if(null != entity.createtime) {
//            po.setCreatetime(CommonTool.StringToDataYMDHMS(entity.createtime));
//        }
//        if(null != entity.updatetime) {
//            po.setUpdatetime(CommonTool.StringToDataYMDHMS(entity.updatetime));
//        }
        return po;
    }

}
