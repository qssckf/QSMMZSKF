/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.vo.so.qs.sc;
	
import nc.vo.pub.*;

/**
 * <b> 在此处简要描述此类的功能 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:
 * @author 
 * @version NCPrj ??
 */
@SuppressWarnings("serial")
public class MmPlanBillVO extends SuperVO {
	private java.lang.String pk_planbill;
	private java.lang.String vsrcid;
	private java.lang.String vsrctype;
	private java.lang.String vsrcbid;
	private java.lang.String pk_group;
	private java.lang.String pk_org;
	private java.lang.String pk_org_v;
	private java.lang.String vbillcode;
	private java.lang.String pk_material;
	private java.lang.String pk_customer;
	private java.lang.String bomid;
	private java.lang.String vbomversion;
	private java.lang.String plannum;
	private java.lang.String plannastnum;
	private java.lang.String vbdef1;
	private java.lang.String vbdef2;
	private java.lang.String vbdef3;
	private java.lang.String vbdef4;
	private java.lang.String vbdef5;
	private java.lang.String vbdef6;
	private java.lang.String vbdef7;
	private java.lang.String vbdef8;
	private java.lang.String vbdef9;
	private java.lang.String vbdef10;
	private java.lang.String vbdef11;
	private java.lang.String vbdef12;
	private java.lang.String vbdef13;
	private java.lang.String vbdef14;
	private java.lang.String vbdef15;
	private java.lang.String vbdef16;
	private java.lang.String vbdef17;
	private java.lang.String vbdef18;
	private java.lang.String vbdef19;
	private java.lang.String vbdef20;
	private java.lang.String creator;
	private nc.vo.pub.lang.UFDateTime creationtime;
	private java.lang.String modifier;
	private nc.vo.pub.lang.UFDateTime modifiedtime;
	private java.lang.String cunit;
	private java.lang.String munit;
	private nc.vo.pub.lang.UFBoolean sfexand;
	private nc.vo.pub.lang.UFBoolean sfclose;
	private java.lang.String vfree1;
	private java.lang.String vfree2;
	private java.lang.String vfree3;
	private java.lang.String vfree4;
	private java.lang.String vfree5;
	private java.lang.String vfree6;
	private java.lang.String vfree7;
	private java.lang.String vfree8;
	private java.lang.String vfree9;
	private java.lang.String vfree10;
	private java.lang.String cprojectid;
	private java.lang.String cproductorid;
	private java.lang.String cvendorid;
	private java.lang.Integer dr = 0;
	private nc.vo.pub.lang.UFDateTime ts;

	public static final String PK_PLANBILL = "pk_planbill";
	public static final String VSRCID = "vsrcid";
	public static final String VSRCTYPE = "vsrctype";
	public static final String VSRCBID = "vsrcbid";
	public static final String PK_GROUP = "pk_group";
	public static final String PK_ORG = "pk_org";
	public static final String PK_ORG_V = "pk_org_v";
	public static final String VBILLCODE = "vbillcode";
	public static final String PK_MATERIAL = "pk_material";
	public static final String PK_CUSTOMER = "pk_customer";
	public static final String BOMID = "bomid";
	public static final String VBOMVERSION = "vbomversion";
	public static final String PLANNUM = "plannum";
	public static final String PLANNASTNUM = "plannastnum";
	public static final String VBDEF1 = "vbdef1";
	public static final String VBDEF2 = "vbdef2";
	public static final String VBDEF3 = "vbdef3";
	public static final String VBDEF4 = "vbdef4";
	public static final String VBDEF5 = "vbdef5";
	public static final String VBDEF6 = "vbdef6";
	public static final String VBDEF7 = "vbdef7";
	public static final String VBDEF8 = "vbdef8";
	public static final String VBDEF9 = "vbdef9";
	public static final String VBDEF10 = "vbdef10";
	public static final String VBDEF11 = "vbdef11";
	public static final String VBDEF12 = "vbdef12";
	public static final String VBDEF13 = "vbdef13";
	public static final String VBDEF14 = "vbdef14";
	public static final String VBDEF15 = "vbdef15";
	public static final String VBDEF16 = "vbdef16";
	public static final String VBDEF17 = "vbdef17";
	public static final String VBDEF18 = "vbdef18";
	public static final String VBDEF19 = "vbdef19";
	public static final String VBDEF20 = "vbdef20";
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	public static final String CUNIT = "cunit";
	public static final String MUNIT = "munit";
	public static final String SFEXAND = "sfexand";
	public static final String SFCLOSE = "sfclose";
	public static final String VFREE1 = "vfree1";
	public static final String VFREE2 = "vfree2";
	public static final String VFREE3 = "vfree3";
	public static final String VFREE4 = "vfree4";
	public static final String VFREE5 = "vfree5";
	public static final String VFREE6 = "vfree6";
	public static final String VFREE7 = "vfree7";
	public static final String VFREE8 = "vfree8";
	public static final String VFREE9 = "vfree9";
	public static final String VFREE10 = "vfree10";
	public static final String CPROJECTID = "cprojectid";
	public static final String CPRODUCTORID = "cproductorid";
	public static final String CVENDORID = "cvendorid";
			
	/**
	 * 属性pk_planbill的Getter方法.属性名：主键
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_planbill () {
		return pk_planbill;
	}   
	/**
	 * 属性pk_planbill的Setter方法.属性名：主键
	 * 创建日期:
	 * @param newPk_planbill java.lang.String
	 */
	public void setPk_planbill (java.lang.String newPk_planbill ) {
	 	this.pk_planbill = newPk_planbill;
	} 	  
	/**
	 * 属性vsrcid的Getter方法.属性名：来源单据id
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVsrcid () {
		return vsrcid;
	}   
	/**
	 * 属性vsrcid的Setter方法.属性名：来源单据id
	 * 创建日期:
	 * @param newVsrcid java.lang.String
	 */
	public void setVsrcid (java.lang.String newVsrcid ) {
	 	this.vsrcid = newVsrcid;
	} 	  
	/**
	 * 属性vsrctype的Getter方法.属性名：来源单据类型
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVsrctype () {
		return vsrctype;
	}   
	/**
	 * 属性vsrctype的Setter方法.属性名：来源单据类型
	 * 创建日期:
	 * @param newVsrctype java.lang.String
	 */
	public void setVsrctype (java.lang.String newVsrctype ) {
	 	this.vsrctype = newVsrctype;
	} 	  
	/**
	 * 属性vsrcbid的Getter方法.属性名：来源单据子表id
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVsrcbid () {
		return vsrcbid;
	}   
	/**
	 * 属性vsrcbid的Setter方法.属性名：来源单据子表id
	 * 创建日期:
	 * @param newVsrcbid java.lang.String
	 */
	public void setVsrcbid (java.lang.String newVsrcbid ) {
	 	this.vsrcbid = newVsrcbid;
	} 	  
	/**
	 * 属性pk_group的Getter方法.属性名：集团
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_group () {
		return pk_group;
	}   
	/**
	 * 属性pk_group的Setter方法.属性名：集团
	 * 创建日期:
	 * @param newPk_group java.lang.String
	 */
	public void setPk_group (java.lang.String newPk_group ) {
	 	this.pk_group = newPk_group;
	} 	  
	/**
	 * 属性pk_org的Getter方法.属性名：组织
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_org () {
		return pk_org;
	}   
	/**
	 * 属性pk_org的Setter方法.属性名：组织
	 * 创建日期:
	 * @param newPk_org java.lang.String
	 */
	public void setPk_org (java.lang.String newPk_org ) {
	 	this.pk_org = newPk_org;
	} 	  
	/**
	 * 属性pk_org_v的Getter方法.属性名：组织版本
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_org_v () {
		return pk_org_v;
	}   
	/**
	 * 属性pk_org_v的Setter方法.属性名：组织版本
	 * 创建日期:
	 * @param newPk_org_v java.lang.String
	 */
	public void setPk_org_v (java.lang.String newPk_org_v ) {
	 	this.pk_org_v = newPk_org_v;
	} 	  
	/**
	 * 属性vbillcode的Getter方法.属性名：调度单据号
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbillcode () {
		return vbillcode;
	}   
	/**
	 * 属性vbillcode的Setter方法.属性名：调度单据号
	 * 创建日期:
	 * @param newVbillcode java.lang.String
	 */
	public void setVbillcode (java.lang.String newVbillcode ) {
	 	this.vbillcode = newVbillcode;
	} 	  
	/**
	 * 属性pk_material的Getter方法.属性名：物料
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_material () {
		return pk_material;
	}   
	/**
	 * 属性pk_material的Setter方法.属性名：物料
	 * 创建日期:
	 * @param newPk_material java.lang.String
	 */
	public void setPk_material (java.lang.String newPk_material ) {
	 	this.pk_material = newPk_material;
	} 	  
	/**
	 * 属性pk_customer的Getter方法.属性名：客户
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_customer () {
		return pk_customer;
	}   
	/**
	 * 属性pk_customer的Setter方法.属性名：客户
	 * 创建日期:
	 * @param newPk_customer java.lang.String
	 */
	public void setPk_customer (java.lang.String newPk_customer ) {
	 	this.pk_customer = newPk_customer;
	} 	  
	/**
	 * 属性bomid的Getter方法.属性名：生产BOM版本
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getBomid () {
		return bomid;
	}   
	/**
	 * 属性bomid的Setter方法.属性名：生产BOM版本
	 * 创建日期:
	 * @param newBomid java.lang.String
	 */
	public void setBomid (java.lang.String newBomid ) {
	 	this.bomid = newBomid;
	} 	  
	/**
	 * 属性vbomversion的Getter方法.属性名：生产BOM版本号
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbomversion () {
		return vbomversion;
	}   
	/**
	 * 属性vbomversion的Setter方法.属性名：生产BOM版本号
	 * 创建日期:
	 * @param newVbomversion java.lang.String
	 */
	public void setVbomversion (java.lang.String newVbomversion ) {
	 	this.vbomversion = newVbomversion;
	} 	  
	/**
	 * 属性plannum的Getter方法.属性名：计划主数量
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPlannum () {
		return plannum;
	}   
	/**
	 * 属性plannum的Setter方法.属性名：计划主数量
	 * 创建日期:
	 * @param newPlannum java.lang.String
	 */
	public void setPlannum (java.lang.String newPlannum ) {
	 	this.plannum = newPlannum;
	} 	  
	/**
	 * 属性plannastnum的Getter方法.属性名：计划辅助数量
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPlannastnum () {
		return plannastnum;
	}   
	/**
	 * 属性plannastnum的Setter方法.属性名：计划辅助数量
	 * 创建日期:
	 * @param newPlannastnum java.lang.String
	 */
	public void setPlannastnum (java.lang.String newPlannastnum ) {
	 	this.plannastnum = newPlannastnum;
	} 	  
	/**
	 * 属性vbdef1的Getter方法.属性名：自定义项1
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef1 () {
		return vbdef1;
	}   
	/**
	 * 属性vbdef1的Setter方法.属性名：自定义项1
	 * 创建日期:
	 * @param newVbdef1 java.lang.String
	 */
	public void setVbdef1 (java.lang.String newVbdef1 ) {
	 	this.vbdef1 = newVbdef1;
	} 	  
	/**
	 * 属性vbdef2的Getter方法.属性名：自定义项2
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef2 () {
		return vbdef2;
	}   
	/**
	 * 属性vbdef2的Setter方法.属性名：自定义项2
	 * 创建日期:
	 * @param newVbdef2 java.lang.String
	 */
	public void setVbdef2 (java.lang.String newVbdef2 ) {
	 	this.vbdef2 = newVbdef2;
	} 	  
	/**
	 * 属性vbdef3的Getter方法.属性名：自定义项3
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef3 () {
		return vbdef3;
	}   
	/**
	 * 属性vbdef3的Setter方法.属性名：自定义项3
	 * 创建日期:
	 * @param newVbdef3 java.lang.String
	 */
	public void setVbdef3 (java.lang.String newVbdef3 ) {
	 	this.vbdef3 = newVbdef3;
	} 	  
	/**
	 * 属性vbdef4的Getter方法.属性名：自定义项4
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef4 () {
		return vbdef4;
	}   
	/**
	 * 属性vbdef4的Setter方法.属性名：自定义项4
	 * 创建日期:
	 * @param newVbdef4 java.lang.String
	 */
	public void setVbdef4 (java.lang.String newVbdef4 ) {
	 	this.vbdef4 = newVbdef4;
	} 	  
	/**
	 * 属性vbdef5的Getter方法.属性名：自定义项5
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef5 () {
		return vbdef5;
	}   
	/**
	 * 属性vbdef5的Setter方法.属性名：自定义项5
	 * 创建日期:
	 * @param newVbdef5 java.lang.String
	 */
	public void setVbdef5 (java.lang.String newVbdef5 ) {
	 	this.vbdef5 = newVbdef5;
	} 	  
	/**
	 * 属性vbdef6的Getter方法.属性名：自定义项6
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef6 () {
		return vbdef6;
	}   
	/**
	 * 属性vbdef6的Setter方法.属性名：自定义项6
	 * 创建日期:
	 * @param newVbdef6 java.lang.String
	 */
	public void setVbdef6 (java.lang.String newVbdef6 ) {
	 	this.vbdef6 = newVbdef6;
	} 	  
	/**
	 * 属性vbdef7的Getter方法.属性名：自定义项7
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef7 () {
		return vbdef7;
	}   
	/**
	 * 属性vbdef7的Setter方法.属性名：自定义项7
	 * 创建日期:
	 * @param newVbdef7 java.lang.String
	 */
	public void setVbdef7 (java.lang.String newVbdef7 ) {
	 	this.vbdef7 = newVbdef7;
	} 	  
	/**
	 * 属性vbdef8的Getter方法.属性名：自定义项8
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef8 () {
		return vbdef8;
	}   
	/**
	 * 属性vbdef8的Setter方法.属性名：自定义项8
	 * 创建日期:
	 * @param newVbdef8 java.lang.String
	 */
	public void setVbdef8 (java.lang.String newVbdef8 ) {
	 	this.vbdef8 = newVbdef8;
	} 	  
	/**
	 * 属性vbdef9的Getter方法.属性名：自定义项9
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef9 () {
		return vbdef9;
	}   
	/**
	 * 属性vbdef9的Setter方法.属性名：自定义项9
	 * 创建日期:
	 * @param newVbdef9 java.lang.String
	 */
	public void setVbdef9 (java.lang.String newVbdef9 ) {
	 	this.vbdef9 = newVbdef9;
	} 	  
	/**
	 * 属性vbdef10的Getter方法.属性名：自定义项10
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef10 () {
		return vbdef10;
	}   
	/**
	 * 属性vbdef10的Setter方法.属性名：自定义项10
	 * 创建日期:
	 * @param newVbdef10 java.lang.String
	 */
	public void setVbdef10 (java.lang.String newVbdef10 ) {
	 	this.vbdef10 = newVbdef10;
	} 	  
	/**
	 * 属性vbdef11的Getter方法.属性名：自定义项11
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef11 () {
		return vbdef11;
	}   
	/**
	 * 属性vbdef11的Setter方法.属性名：自定义项11
	 * 创建日期:
	 * @param newVbdef11 java.lang.String
	 */
	public void setVbdef11 (java.lang.String newVbdef11 ) {
	 	this.vbdef11 = newVbdef11;
	} 	  
	/**
	 * 属性vbdef12的Getter方法.属性名：自定义项12
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef12 () {
		return vbdef12;
	}   
	/**
	 * 属性vbdef12的Setter方法.属性名：自定义项12
	 * 创建日期:
	 * @param newVbdef12 java.lang.String
	 */
	public void setVbdef12 (java.lang.String newVbdef12 ) {
	 	this.vbdef12 = newVbdef12;
	} 	  
	/**
	 * 属性vbdef13的Getter方法.属性名：自定义项13
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef13 () {
		return vbdef13;
	}   
	/**
	 * 属性vbdef13的Setter方法.属性名：自定义项13
	 * 创建日期:
	 * @param newVbdef13 java.lang.String
	 */
	public void setVbdef13 (java.lang.String newVbdef13 ) {
	 	this.vbdef13 = newVbdef13;
	} 	  
	/**
	 * 属性vbdef14的Getter方法.属性名：自定义项14
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef14 () {
		return vbdef14;
	}   
	/**
	 * 属性vbdef14的Setter方法.属性名：自定义项14
	 * 创建日期:
	 * @param newVbdef14 java.lang.String
	 */
	public void setVbdef14 (java.lang.String newVbdef14 ) {
	 	this.vbdef14 = newVbdef14;
	} 	  
	/**
	 * 属性vbdef15的Getter方法.属性名：自定义项15
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef15 () {
		return vbdef15;
	}   
	/**
	 * 属性vbdef15的Setter方法.属性名：自定义项15
	 * 创建日期:
	 * @param newVbdef15 java.lang.String
	 */
	public void setVbdef15 (java.lang.String newVbdef15 ) {
	 	this.vbdef15 = newVbdef15;
	} 	  
	/**
	 * 属性vbdef16的Getter方法.属性名：自定义项16
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef16 () {
		return vbdef16;
	}   
	/**
	 * 属性vbdef16的Setter方法.属性名：自定义项16
	 * 创建日期:
	 * @param newVbdef16 java.lang.String
	 */
	public void setVbdef16 (java.lang.String newVbdef16 ) {
	 	this.vbdef16 = newVbdef16;
	} 	  
	/**
	 * 属性vbdef17的Getter方法.属性名：自定义项17
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef17 () {
		return vbdef17;
	}   
	/**
	 * 属性vbdef17的Setter方法.属性名：自定义项17
	 * 创建日期:
	 * @param newVbdef17 java.lang.String
	 */
	public void setVbdef17 (java.lang.String newVbdef17 ) {
	 	this.vbdef17 = newVbdef17;
	} 	  
	/**
	 * 属性vbdef18的Getter方法.属性名：自定义项18
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef18 () {
		return vbdef18;
	}   
	/**
	 * 属性vbdef18的Setter方法.属性名：自定义项18
	 * 创建日期:
	 * @param newVbdef18 java.lang.String
	 */
	public void setVbdef18 (java.lang.String newVbdef18 ) {
	 	this.vbdef18 = newVbdef18;
	} 	  
	/**
	 * 属性vbdef19的Getter方法.属性名：自定义项19
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef19 () {
		return vbdef19;
	}   
	/**
	 * 属性vbdef19的Setter方法.属性名：自定义项19
	 * 创建日期:
	 * @param newVbdef19 java.lang.String
	 */
	public void setVbdef19 (java.lang.String newVbdef19 ) {
	 	this.vbdef19 = newVbdef19;
	} 	  
	/**
	 * 属性vbdef20的Getter方法.属性名：自定义项20
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef20 () {
		return vbdef20;
	}   
	/**
	 * 属性vbdef20的Setter方法.属性名：自定义项20
	 * 创建日期:
	 * @param newVbdef20 java.lang.String
	 */
	public void setVbdef20 (java.lang.String newVbdef20 ) {
	 	this.vbdef20 = newVbdef20;
	} 	  
	/**
	 * 属性creator的Getter方法.属性名：创建人
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getCreator () {
		return creator;
	}   
	/**
	 * 属性creator的Setter方法.属性名：创建人
	 * 创建日期:
	 * @param newCreator java.lang.String
	 */
	public void setCreator (java.lang.String newCreator ) {
	 	this.creator = newCreator;
	} 	  
	/**
	 * 属性creationtime的Getter方法.属性名：创建时间
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getCreationtime () {
		return creationtime;
	}   
	/**
	 * 属性creationtime的Setter方法.属性名：创建时间
	 * 创建日期:
	 * @param newCreationtime nc.vo.pub.lang.UFDateTime
	 */
	public void setCreationtime (nc.vo.pub.lang.UFDateTime newCreationtime ) {
	 	this.creationtime = newCreationtime;
	} 	  
	/**
	 * 属性modifier的Getter方法.属性名：修改人
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getModifier () {
		return modifier;
	}   
	/**
	 * 属性modifier的Setter方法.属性名：修改人
	 * 创建日期:
	 * @param newModifier java.lang.String
	 */
	public void setModifier (java.lang.String newModifier ) {
	 	this.modifier = newModifier;
	} 	  
	/**
	 * 属性modifiedtime的Getter方法.属性名：修改时间
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getModifiedtime () {
		return modifiedtime;
	}   
	/**
	 * 属性modifiedtime的Setter方法.属性名：修改时间
	 * 创建日期:
	 * @param newModifiedtime nc.vo.pub.lang.UFDateTime
	 */
	public void setModifiedtime (nc.vo.pub.lang.UFDateTime newModifiedtime ) {
	 	this.modifiedtime = newModifiedtime;
	} 	  
	/**
	 * 属性cunit的Getter方法.属性名：主单位
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getCunit () {
		return cunit;
	}   
	/**
	 * 属性cunit的Setter方法.属性名：主单位
	 * 创建日期:
	 * @param newCunit java.lang.String
	 */
	public void setCunit (java.lang.String newCunit ) {
	 	this.cunit = newCunit;
	} 	  
	/**
	 * 属性munit的Getter方法.属性名：生产单位
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getMunit () {
		return munit;
	}   
	/**
	 * 属性munit的Setter方法.属性名：生产单位
	 * 创建日期:
	 * @param newMunit java.lang.String
	 */
	public void setMunit (java.lang.String newMunit ) {
	 	this.munit = newMunit;
	} 	  
	/**
	 * 属性sfexand的Getter方法.属性名：展开标志
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public nc.vo.pub.lang.UFBoolean getSfexand () {
		return sfexand;
	}   
	/**
	 * 属性sfexand的Setter方法.属性名：展开标志
	 * 创建日期:
	 * @param newSfexand nc.vo.pub.lang.UFBoolean
	 */
	public void setSfexand (nc.vo.pub.lang.UFBoolean newSfexand ) {
	 	this.sfexand = newSfexand;
	} 	  
	/**
	 * 属性sfclose的Getter方法.属性名：关闭标志
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public nc.vo.pub.lang.UFBoolean getSfclose () {
		return sfclose;
	}   
	/**
	 * 属性sfclose的Setter方法.属性名：关闭标志
	 * 创建日期:
	 * @param newSfclose nc.vo.pub.lang.UFBoolean
	 */
	public void setSfclose (nc.vo.pub.lang.UFBoolean newSfclose ) {
	 	this.sfclose = newSfclose;
	} 	  
	/**
	 * 属性vfree1的Getter方法.属性名：自由项1
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree1 () {
		return vfree1;
	}   
	/**
	 * 属性vfree1的Setter方法.属性名：自由项1
	 * 创建日期:
	 * @param newVfree1 java.lang.String
	 */
	public void setVfree1 (java.lang.String newVfree1 ) {
	 	this.vfree1 = newVfree1;
	} 	  
	/**
	 * 属性vfree2的Getter方法.属性名：自由项2
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree2 () {
		return vfree2;
	}   
	/**
	 * 属性vfree2的Setter方法.属性名：自由项2
	 * 创建日期:
	 * @param newVfree2 java.lang.String
	 */
	public void setVfree2 (java.lang.String newVfree2 ) {
	 	this.vfree2 = newVfree2;
	} 	  
	/**
	 * 属性vfree3的Getter方法.属性名：自由项3
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree3 () {
		return vfree3;
	}   
	/**
	 * 属性vfree3的Setter方法.属性名：自由项3
	 * 创建日期:
	 * @param newVfree3 java.lang.String
	 */
	public void setVfree3 (java.lang.String newVfree3 ) {
	 	this.vfree3 = newVfree3;
	} 	  
	/**
	 * 属性vfree4的Getter方法.属性名：自由项4
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree4 () {
		return vfree4;
	}   
	/**
	 * 属性vfree4的Setter方法.属性名：自由项4
	 * 创建日期:
	 * @param newVfree4 java.lang.String
	 */
	public void setVfree4 (java.lang.String newVfree4 ) {
	 	this.vfree4 = newVfree4;
	} 	  
	/**
	 * 属性vfree5的Getter方法.属性名：自由项5
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree5 () {
		return vfree5;
	}   
	/**
	 * 属性vfree5的Setter方法.属性名：自由项5
	 * 创建日期:
	 * @param newVfree5 java.lang.String
	 */
	public void setVfree5 (java.lang.String newVfree5 ) {
	 	this.vfree5 = newVfree5;
	} 	  
	/**
	 * 属性vfree6的Getter方法.属性名：自由项6
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree6 () {
		return vfree6;
	}   
	/**
	 * 属性vfree6的Setter方法.属性名：自由项6
	 * 创建日期:
	 * @param newVfree6 java.lang.String
	 */
	public void setVfree6 (java.lang.String newVfree6 ) {
	 	this.vfree6 = newVfree6;
	} 	  
	/**
	 * 属性vfree7的Getter方法.属性名：自由项7
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree7 () {
		return vfree7;
	}   
	/**
	 * 属性vfree7的Setter方法.属性名：自由项7
	 * 创建日期:
	 * @param newVfree7 java.lang.String
	 */
	public void setVfree7 (java.lang.String newVfree7 ) {
	 	this.vfree7 = newVfree7;
	} 	  
	/**
	 * 属性vfree8的Getter方法.属性名：自由项8
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree8 () {
		return vfree8;
	}   
	/**
	 * 属性vfree8的Setter方法.属性名：自由项8
	 * 创建日期:
	 * @param newVfree8 java.lang.String
	 */
	public void setVfree8 (java.lang.String newVfree8 ) {
	 	this.vfree8 = newVfree8;
	} 	  
	/**
	 * 属性vfree9的Getter方法.属性名：自由项9
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree9 () {
		return vfree9;
	}   
	/**
	 * 属性vfree9的Setter方法.属性名：自由项9
	 * 创建日期:
	 * @param newVfree9 java.lang.String
	 */
	public void setVfree9 (java.lang.String newVfree9 ) {
	 	this.vfree9 = newVfree9;
	} 	  
	/**
	 * 属性vfree10的Getter方法.属性名：自由项10
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVfree10 () {
		return vfree10;
	}   
	/**
	 * 属性vfree10的Setter方法.属性名：自由项10
	 * 创建日期:
	 * @param newVfree10 java.lang.String
	 */
	public void setVfree10 (java.lang.String newVfree10 ) {
	 	this.vfree10 = newVfree10;
	} 	  
	/**
	 * 属性cprojectid的Getter方法.属性名：项目
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getCprojectid () {
		return cprojectid;
	}   
	/**
	 * 属性cprojectid的Setter方法.属性名：项目
	 * 创建日期:
	 * @param newCprojectid java.lang.String
	 */
	public void setCprojectid (java.lang.String newCprojectid ) {
	 	this.cprojectid = newCprojectid;
	} 	  
	/**
	 * 属性cproductorid的Getter方法.属性名：生产厂商
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getCproductorid () {
		return cproductorid;
	}   
	/**
	 * 属性cproductorid的Setter方法.属性名：生产厂商
	 * 创建日期:
	 * @param newCproductorid java.lang.String
	 */
	public void setCproductorid (java.lang.String newCproductorid ) {
	 	this.cproductorid = newCproductorid;
	} 	  
	/**
	 * 属性cvendorid的Getter方法.属性名：供应商
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getCvendorid () {
		return cvendorid;
	}   
	/**
	 * 属性cvendorid的Setter方法.属性名：供应商
	 * 创建日期:
	 * @param newCvendorid java.lang.String
	 */
	public void setCvendorid (java.lang.String newCvendorid ) {
	 	this.cvendorid = newCvendorid;
	} 	  
	/**
	 * 属性dr的Getter方法.属性名：dr
	 * 创建日期:
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDr () {
		return dr;
	}   
	/**
	 * 属性dr的Setter方法.属性名：dr
	 * 创建日期:
	 * @param newDr java.lang.Integer
	 */
	public void setDr (java.lang.Integer newDr ) {
	 	this.dr = newDr;
	} 	  
	/**
	 * 属性ts的Getter方法.属性名：ts
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getTs () {
		return ts;
	}   
	/**
	 * 属性ts的Setter方法.属性名：ts
	 * 创建日期:
	 * @param newTs nc.vo.pub.lang.UFDateTime
	 */
	public void setTs (nc.vo.pub.lang.UFDateTime newTs ) {
	 	this.ts = newTs;
	} 	  
 
	/**
	  * <p>取得父VO主键字段.
	  * <p>
	  * 创建日期:
	  * @return java.lang.String
	  */
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	/**
	  * <p>取得表主键.
	  * <p>
	  * 创建日期:
	  * @return java.lang.String
	  */
	public java.lang.String getPKFieldName() {
	  return "pk_planbill";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "so_mmplan";
	}    
	
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public static java.lang.String getDefaultTableName() {
		return "so_mmplan";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:
	  */
     public MmPlanBillVO() {
		super();	
	}    
	
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.so.qs.sc.MmPlanBillVO" )
	public IVOMeta getMetaData() {
   		return null;
  	}
} 


