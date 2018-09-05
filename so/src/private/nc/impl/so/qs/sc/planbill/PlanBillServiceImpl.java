package nc.impl.so.qs.sc.planbill;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.hr.frame.persistence.AppendBeanArrayProcessor;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.vo.bd.pub.sqlutil.BDSqlInUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class PlanBillServiceImpl implements IPlanBillSerive{
	
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		
		if(this.dao==null){
			
			this.dao=new BaseDAO();
		}
		
		return dao;
	}

	@Override
	public String[] queryVOPks(String sqlwhere) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		String sql="select so_preorder_b.pk_group,so_preorder_b.pk_org,org_orgs.pk_vid pk_org_v,'38' vsrctype,so_preorder.vbillcode vscrcode,so_preorder_b.cpreorderid vsrcid,so_preorder_b.cpreorderbid vsrcbid,so_mmplan.vbillcode,so_preorder.ccustomerid pk_customer,";
		sql=sql+"so_preorder.vdef1 endcustomer,so_preorder.dbilldate,so_preorder_b.dsenddate deliverydate,so_preorder_b.cmaterialid pk_material,so_preorder_b.cunitid cunit,so_preorder_b.castunitid qunit,so_preorder_b.cprojectid cprojectid,so_preorder_b.cproductorid cproductorid,";
		sql=sql+"so_preorder_b.cvendorid cvendorid,so_preorder_b.vfree1,so_preorder_b.vfree2,so_preorder_b.vfree3,so_preorder_b.vfree4,so_preorder_b.vfree5,so_preorder_b.vfree6,so_preorder_b.vfree7,so_preorder_b.vfree8,so_preorder_b.vfree9,so_preorder_b.vfree10,";
		sql=sql+"so_preorder_b.vbdef1 silkwide,so_preorder_b.vbdef2 tagline,so_preorder_b.vbdef3 cutcloth,so_preorder_b.vbdef4 latitudedensity,so_preorder_b.vbdef5 width,so_preorder_b.vbdef6 tensiondd,so_preorder_b.vbdef7 length,so_preorder_b.vbdef8 otherproduction,so_preorder_b.vbdef9 elongation,so_preorder_b.vbdef10 spacer,";
		sql=sql+"so_preorder_b.nnum plannum,so_preorder_b.nastnum plannastnum,so_mmplan.bomid,so_mmplan.vbomversion,so_mmplan.sfexand,so_mmplan.sfclose,so_mmplan.vbdef1,so_mmplan.vbdef2,so_mmplan.vbdef3,so_mmplan.vbdef4,so_mmplan.vbdef5,so_mmplan.vbdef6,so_mmplan.vbdef7,so_mmplan.vbdef8,so_mmplan.vbdef9,so_mmplan.vbdef10,so_mmplan.vbdef11,";
		sql=sql+"so_mmplan.vbdef12,so_mmplan.vbdef13,so_mmplan.vbdef14,so_mmplan.vbdef15,so_mmplan.vbdef16,so_mmplan.vbdef17,so_mmplan.vbdef18,so_mmplan.vbdef19,so_mmplan.vbdef20,so_mmplan.creator,so_mmplan.creationtime,so_mmplan.modifier,so_mmplan.modifiedtime";
		sql=sql+" from so_preorder_b inner join so_preorder on so_preorder_b.cpreorderid=so_preorder.cpreorderid";
		sql=sql+" left join so_mmplan on so_preorder_b.cpreorderbid=so_mmplan.vsrcbid";
		sql=sql+" left join org_orgs on so_preorder_b.pk_org=org_orgs.pk_org";
		sql=sql +" where so_preorder.fstatusflag=2 and so_preorder_b.dr=0 and so_preorder.dr=0 and "+sqlwhere;
		
		MmPlanBillVO[] vos=(MmPlanBillVO[])executeQueryAppendableVOs(sql,MmPlanBillVO.class);
		
		
		String[] pks = new String[0];
		
		if(vos!=null){
			pks = new String[vos.length];
			for (int i = 0; i < vos.length; i++) {
				pks[i]=vos[i].getVsrcbid();
			}
		}
		return pks;
		
	}
	
	
	private <T> T[] executeQueryAppendableVOs(String sql,Class voclass) throws DAOException {
		
		return (T[])this.getDao().executeQuery(sql.toString(), new AppendBeanArrayProcessor(voclass));
	}

	@Override
	public SuperVO[] queryVObyPks(String[] pks) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		String inSql = BDSqlInUtil.getInSql(pks, false);
		
		String sql="select so_preorder_b.pk_group,so_preorder_b.pk_org,org_orgs.pk_vid pk_org_v,'38' vsrctype,so_preorder.vbillcode vscrcode,so_preorder_b.cpreorderid vsrcid,so_preorder_b.cpreorderbid vsrcbid,so_mmplan.vbillcode,so_preorder.ccustomerid pk_customer,";
		sql=sql+"so_preorder.vdef1 endcustomer,so_preorder.dbilldate,so_preorder_b.dsenddate deliverydate,so_preorder_b.cmaterialid pk_material,so_preorder_b.cunitid cunit,so_preorder_b.castunitid qunit,so_preorder_b.cprojectid cprojectid,so_preorder_b.cproductorid cproductorid,";
		sql=sql+"so_preorder_b.cvendorid cvendorid,so_preorder_b.vfree1,so_preorder_b.vfree2,so_preorder_b.vfree3,so_preorder_b.vfree4,so_preorder_b.vfree5,so_preorder_b.vfree6,so_preorder_b.vfree7,so_preorder_b.vfree8,so_preorder_b.vfree9,so_preorder_b.vfree10,";
		sql=sql+"so_preorder_b.vbdef1 silkwide,so_preorder_b.vbdef2 tagline,so_preorder_b.vbdef3 cutcloth,so_preorder_b.vbdef4 latitudedensity,so_preorder_b.vbdef5 width,so_preorder_b.vbdef6 tensiondd,so_preorder_b.vbdef7 length,so_preorder_b.vbdef8 otherproduction,so_preorder_b.vbdef9 elongation,so_preorder_b.vbdef10 spacer,";
		sql=sql+"so_preorder_b.nnum plannum,so_preorder_b.nastnum plannastnum,so_mmplan.bomid,so_mmplan.vbomversion,so_mmplan.sfexand,so_mmplan.sfclose,so_mmplan.vbdef1,so_mmplan.vbdef2,so_mmplan.vbdef3,so_mmplan.vbdef4,so_mmplan.vbdef5,so_mmplan.vbdef6,so_mmplan.vbdef7,so_mmplan.vbdef8,so_mmplan.vbdef9,so_mmplan.vbdef10,so_mmplan.vbdef11,";
		sql=sql+"so_mmplan.vbdef12,so_mmplan.vbdef13,so_mmplan.vbdef14,so_mmplan.vbdef15,so_mmplan.vbdef16,so_mmplan.vbdef17,so_mmplan.vbdef18,so_mmplan.vbdef19,so_mmplan.vbdef20,so_mmplan.creator,so_mmplan.creationtime,so_mmplan.modifier,so_mmplan.modifiedtime";
		sql=sql+" from so_preorder_b inner join so_preorder on so_preorder_b.cpreorderid=so_preorder.cpreorderid";
		sql=sql+" left join so_mmplan on so_preorder_b.cpreorderbid=so_mmplan.vsrcbid";
		sql=sql+" left join org_orgs on so_preorder_b.pk_org=org_orgs.pk_org";
		sql=sql +" where so_preorder.fstatusflag=2 and so_preorder_b.dr=0 and so_preorder.dr=0 and so_preorder_b.cpreorderbid in "+inSql;
		
		
		
		return null;
	}

}
