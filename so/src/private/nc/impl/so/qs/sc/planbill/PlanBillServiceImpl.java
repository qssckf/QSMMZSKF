package nc.impl.so.qs.sc.planbill;

import java.util.Collection;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.hr.frame.persistence.AppendBeanArrayProcessor;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.vo.bd.pub.sqlutil.BDSqlInUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.MmPlanBillVO;
import nc.vo.so.qs.sc.planbill.process.BomChVO;
import nc.vo.so.qs.sc.planbill.process.BomVersionVO;

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
		// TODO 自动生成的方法存根
		
		String sql="select case when so_mmplan.pk_planbill is null then so_preorder_b.cpreorderbid else so_mmplan.pk_planbill end pk_planbill,so_preorder_b.pk_group,so_preorder_b.pk_org,org_orgs.pk_vid pk_org_v,'38' vsrctype,so_preorder.vbillcode vscrcode,so_preorder_b.cpreorderid vsrcid,so_preorder_b.cpreorderbid vsrcbid,so_mmplan.vbillcode,so_preorder.ccustomerid pk_customer,";
		sql=sql+"so_preorder.vdef1 endcustomer,so_preorder.dbilldate,so_preorder_b.dsenddate deliverydate,so_preorder_b.cmaterialid pk_material,so_preorder_b.cunitid cunit,so_preorder_b.castunitid qunit,so_preorder_b.cprojectid cprojectid,so_preorder_b.cproductorid cproductorid,";
		sql=sql+"so_preorder_b.cvendorid cvendorid,so_preorder_b.vfree1,so_preorder_b.vfree2,so_preorder_b.vfree3,so_preorder_b.vfree4,so_preorder_b.vfree5,so_preorder_b.vfree6,so_preorder_b.vfree7,so_preorder_b.vfree8,so_preorder_b.vfree9,so_preorder_b.vfree10,";
		sql=sql+"so_preorder_b.vbdef1 silkwide,so_preorder_b.vbdef2 tagline,so_preorder_b.vbdef3 cutcloth,so_preorder_b.vbdef4 latitudedensity,so_preorder_b.vbdef5 width,so_preorder_b.vbdef6 tensiondd,so_preorder_b.vbdef7 length,so_preorder_b.vbdef8 otherproduction,so_preorder_b.vbdef9 elongation,so_preorder_b.vbdef10 spacer,";
		sql=sql+"so_preorder_b.nnum plannum,so_preorder_b.nastnum plannastnum,so_mmplan.bomid,so_mmplan.vbomversion,nvl(so_mmplan.sfexand,'N') sfexand,nvl(so_mmplan.sfclose,'N') sfclose,so_mmplan.vbdef1,so_mmplan.vbdef2,so_mmplan.vbdef3,so_mmplan.vbdef4,so_mmplan.vbdef5,so_mmplan.vbdef6,so_mmplan.vbdef7,so_mmplan.vbdef8,so_mmplan.vbdef9,so_mmplan.vbdef10,so_mmplan.vbdef11,";
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
		// TODO 自动生成的方法存根
		
		String inSql = BDSqlInUtil.getInSql(pks, false);
		
		String sql="select case when so_mmplan.pk_planbill is null then so_preorder_b.cpreorderbid else so_mmplan.pk_planbill end pk_planbill,so_preorder_b.pk_group,so_preorder_b.pk_org,org_orgs.pk_vid pk_org_v,'38' vsrctype,so_preorder.vbillcode vscrcode,so_preorder_b.cpreorderid vsrcid,so_preorder_b.cpreorderbid vsrcbid,so_mmplan.vbillcode,so_preorder.ccustomerid pk_customer,";
		sql=sql+"so_preorder.vdef1 endcustomer,so_preorder.dbilldate,so_preorder_b.dsenddate deliverydate,so_preorder_b.cmaterialid pk_material,so_preorder_b.cunitid cunit,so_preorder_b.castunitid qunit,so_preorder_b.cprojectid cprojectid,so_preorder_b.cproductorid cproductorid,";
		sql=sql+"so_preorder_b.cvendorid cvendorid,so_preorder_b.vfree1,so_preorder_b.vfree2,so_preorder_b.vfree3,so_preorder_b.vfree4,so_preorder_b.vfree5,so_preorder_b.vfree6,so_preorder_b.vfree7,so_preorder_b.vfree8,so_preorder_b.vfree9,so_preorder_b.vfree10,";
		sql=sql+"so_preorder_b.vbdef1 silkwide,so_preorder_b.vbdef2 tagline,so_preorder_b.vbdef3 cutcloth,so_preorder_b.vbdef4 latitudedensity,so_preorder_b.vbdef5 width,so_preorder_b.vbdef6 tensiondd,so_preorder_b.vbdef7 length,so_preorder_b.vbdef8 otherproduction,so_preorder_b.vbdef9 elongation,so_preorder_b.vbdef10 spacer,";
		sql=sql+"so_preorder_b.nnum plannum,so_preorder_b.nastnum plannastnum,so_mmplan.bomid,so_mmplan.vbomversion,nvl(so_mmplan.sfexand,'N') sfexand,nvl(so_mmplan.sfclose,'N') sfclose,so_mmplan.vbdef1,so_mmplan.vbdef2,so_mmplan.vbdef3,so_mmplan.vbdef4,so_mmplan.vbdef5,so_mmplan.vbdef6,so_mmplan.vbdef7,so_mmplan.vbdef8,so_mmplan.vbdef9,so_mmplan.vbdef10,so_mmplan.vbdef11,";
		sql=sql+"so_mmplan.vbdef12,so_mmplan.vbdef13,so_mmplan.vbdef14,so_mmplan.vbdef15,so_mmplan.vbdef16,so_mmplan.vbdef17,so_mmplan.vbdef18,so_mmplan.vbdef19,so_mmplan.vbdef20,so_mmplan.creator,so_mmplan.creationtime,so_mmplan.modifier,so_mmplan.modifiedtime";
		sql=sql+" from so_preorder_b inner join so_preorder on so_preorder_b.cpreorderid=so_preorder.cpreorderid";
		sql=sql+" left join so_mmplan on so_preorder_b.cpreorderbid=so_mmplan.vsrcbid";
		sql=sql+" left join org_orgs on so_preorder_b.pk_org=org_orgs.pk_org";
		sql=sql +" where so_preorder.fstatusflag=2 and so_preorder_b.dr=0 and so_preorder.dr=0 and so_preorder_b.cpreorderbid in "+inSql;
		
		MmPlanBillVO[] vos=(MmPlanBillVO[])executeQueryAppendableVOs(sql,MmPlanBillVO.class);
		
		return vos;
	}

	@Override
	public Boolean QueryPlanBillIsExists(String pk) throws BusinessException {
		// TODO 自动生成的方法存根
		
		Collection<MmPlanBillVO> planVos= this.getDao().retrieveByClause(MmPlanBillVO.class, "pk_planbill='"+pk+"'");
		
		if(planVos!=null && planVos.size()==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public SuperVO[] queryBomVersion(String pk_materail,String pk_org) throws BusinessException {
		// TODO 自动生成的方法存根
		
		String sql="select bd_bom.pk_org,cbomid,hcmaterialid pk_material,bd_material.name matername,bd_material.materialspec materspec,bd_material.materialtype matertype,";
		sql=sql+"decode(bd_bom.fbomtype,1,'生产BOM',2,'包装BOM',3,'配置BOM') bomtype,bd_bom.hversion bomversion,bd_bom.hvnote memo from bd_bom";
		sql=sql+" left join bd_material on bd_bom.hcmaterialid=bd_material.pk_material";
		sql=sql+" where bd_bom.dr=0 and bd_bom.hcmaterialid='"+pk_materail+"' and bd_bom.pk_org='"+pk_org+"'";
		
		BomVersionVO[] vos=(BomVersionVO[])executeQueryAppendableVOs(sql,BomVersionVO.class);
		
		return vos;
	}

	@Override
	public SuperVO[] queryBomChildren(String bomid, String pk_org) throws BusinessException {
		// TODO 自动生成的方法存根
		
		String sql="select hcmaterialid pk_materail,parentmatcode,parentmatname,matercode,matername,cbomversion,materspec,matertype,level bomlevel,munit,nitemnum itemnum,vnote itemmemo from ";
		sql=sql+"(select a.pk_org,b.cbom_bid,a.cbomid,a.hcmaterialid ,mar.code parentmatcode,mar.name parentmatname,a.hversion,b.vitemversion,bbom.hversion cbomversion,b.cmaterialid,cmar.code matercode,cmar.name matername,cmar.materialspec materspec,cmar.materialtype matertype,unit.name munit,b.nitemnum,b.vnote ";
		sql=sql+"from bd_bom a ";
		sql=sql+"inner join bd_bom_b b on a.cbomid=b.cbomid ";
		sql=sql+"left join bd_material mar on a.hcmaterialid=mar.pk_material ";
		sql=sql+"left join bd_material cmar on b.cmaterialid=cmar.pk_material ";
		sql=sql+"left join bd_bom bbom on b.vitemversion=bbom.cbomid ";
		sql=sql+"left join bd_measdoc unit on b.cmeasureid=unit.pk_measdoc ";
		sql=sql+"where a.pk_org='"+pk_org+"' and a.dr=0 and b.dr=0 and b.vitemversion<>'~') start with cbomid='"+bomid+"' connect by prior vitemversion=cbomid order by level";
		
		BomChVO[] vos=(BomChVO[])executeQueryAppendableVOs(sql,BomChVO.class);
		
		return vos;
	}

}
