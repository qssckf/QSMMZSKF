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
public class RdPorductDetailVO extends SuperVO {
	private java.lang.String pk_rdpd;
	private java.lang.String vsrcplanbid;
	private java.lang.String vsrcplanid;
	private java.lang.String pk_dept;
	private java.lang.String pk_group;
	private java.lang.String pk_org;
	private java.lang.String pk_org_v;
	private java.lang.String def1;
	private java.lang.String def2;
	private java.lang.String def3;
	private java.lang.String def4;
	private java.lang.String def5;
	private java.lang.String def6;
	private java.lang.String def7;
	private java.lang.String def8;
	private java.lang.String def9;
	private java.lang.String def10;
	private java.lang.String def11;
	private java.lang.String def12;
	private java.lang.String def13;
	private java.lang.String def14;
	private java.lang.String def15;
	private java.lang.String def16;
	private java.lang.String def17;
	private java.lang.String def18;
	private java.lang.String def19;
	private java.lang.String def20;
	private java.lang.String pk_material;
	private java.lang.String splitstofftype;
	private nc.vo.pub.lang.UFDouble silkwide;
	private nc.vo.pub.lang.UFDouble elongation;
	private nc.vo.pub.lang.UFDouble tension;
	private nc.vo.pub.lang.UFBoolean spacer;
	private java.lang.String otherproduction;
	private java.lang.String tagline;
	private nc.vo.pub.lang.UFDouble latitudedensity;
	private nc.vo.pub.lang.UFDouble width;
	private nc.vo.pub.lang.UFDouble length;
	private java.lang.String pk_machine;
	private nc.vo.pub.lang.UFDouble prodnum;
	private nc.vo.pub.lang.UFDouble prodnastnum;
	private nc.vo.pub.lang.UFDateTime proddate;
	private nc.vo.pub.lang.UFDateTime enddate;
	private java.lang.String pk_bomid;
	private java.lang.String vbomversion;
	private java.lang.String creator;
	private nc.vo.pub.lang.UFDateTime creationtime;
	private java.lang.String modifier;
	private nc.vo.pub.lang.UFDateTime modifiedtime;
	private nc.vo.pub.lang.UFBoolean sfmakebill;
	private java.lang.String cprojectid;
	private java.lang.String cproductorid;
	private java.lang.String cvendorid;
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
	private java.lang.Integer dr = 0;
	private nc.vo.pub.lang.UFDateTime ts;

	public static final String PK_RDPD = "pk_rdpd";
	public static final String VSRCPLANBID = "vsrcplanbid";
	public static final String VSRCPLANID = "vsrcplanid";
	public static final String PK_DEPT = "pk_dept";
	public static final String PK_GROUP = "pk_group";
	public static final String PK_ORG = "pk_org";
	public static final String PK_ORG_V = "pk_org_v";
	public static final String DEF1 = "def1";
	public static final String DEF2 = "def2";
	public static final String DEF3 = "def3";
	public static final String DEF4 = "def4";
	public static final String DEF5 = "def5";
	public static final String DEF6 = "def6";
	public static final String DEF7 = "def7";
	public static final String DEF8 = "def8";
	public static final String DEF9 = "def9";
	public static final String DEF10 = "def10";
	public static final String DEF11 = "def11";
	public static final String DEF12 = "def12";
	public static final String DEF13 = "def13";
	public static final String DEF14 = "def14";
	public static final String DEF15 = "def15";
	public static final String DEF16 = "def16";
	public static final String DEF17 = "def17";
	public static final String DEF18 = "def18";
	public static final String DEF19 = "def19";
	public static final String DEF20 = "def20";
	public static final String PK_MATERIAL = "pk_material";
	public static final String SPLITSTOFFTYPE = "splitstofftype";
	public static final String SILKWIDE = "silkwide";
	public static final String ELONGATION = "elongation";
	public static final String TENSION = "tension";
	public static final String SPACER = "spacer";
	public static final String OTHERPRODUCTION = "otherproduction";
	public static final String TAGLINE = "tagline";
	public static final String LATITUDEDENSITY = "latitudedensity";
	public static final String WIDTH = "width";
	public static final String LENGTH = "length";
	public static final String PK_MACHINE = "pk_machine";
	public static final String PRODNUM = "prodnum";
	public static final String PRODNASTNUM = "prodnastnum";
	public static final String PRODDATE = "proddate";
	public static final String ENDDATE = "enddate";
	public static final String PK_BOMID = "pk_bomid";
	public static final String VBOMVERSION = "vbomversion";
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	public static final String SFMAKEBILL = "sfmakebill";
	public static final String CPROJECTID = "cprojectid";
	public static final String CPRODUCTORID = "cproductorid";
	public static final String CVENDORID = "cvendorid";
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
			
	/**
	 * 属性pk_rdpd的Getter方法.属性名：主键
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_rdpd () {
		return pk_rdpd;
	}   
	/**
	 * 属性pk_rdpd的Setter方法.属性名：主键
	 * 创建日期:
	 * @param newPk_rdpd java.lang.String
	 */
	public void setPk_rdpd (java.lang.String newPk_rdpd ) {
	 	this.pk_rdpd = newPk_rdpd;
	} 	  
	/**
	 * 属性vsrcplanbid的Getter方法.属性名：来源调度单子表主键
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVsrcplanbid () {
		return vsrcplanbid;
	}   
	/**
	 * 属性vsrcplanbid的Setter方法.属性名：来源调度单子表主键
	 * 创建日期:
	 * @param newVsrcplanbid java.lang.String
	 */
	public void setVsrcplanbid (java.lang.String newVsrcplanbid ) {
	 	this.vsrcplanbid = newVsrcplanbid;
	} 	  
	/**
	 * 属性vsrcplanid的Getter方法.属性名：来源调度单主键
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVsrcplanid () {
		return vsrcplanid;
	}   
	/**
	 * 属性vsrcplanid的Setter方法.属性名：来源调度单主键
	 * 创建日期:
	 * @param newVsrcplanid java.lang.String
	 */
	public void setVsrcplanid (java.lang.String newVsrcplanid ) {
	 	this.vsrcplanid = newVsrcplanid;
	} 	  
	/**
	 * 属性pk_dept的Getter方法.属性名：生产部门
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_dept () {
		return pk_dept;
	}   
	/**
	 * 属性pk_dept的Setter方法.属性名：生产部门
	 * 创建日期:
	 * @param newPk_dept java.lang.String
	 */
	public void setPk_dept (java.lang.String newPk_dept ) {
	 	this.pk_dept = newPk_dept;
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
	 * 属性def1的Getter方法.属性名：自定义项1
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef1 () {
		return def1;
	}   
	/**
	 * 属性def1的Setter方法.属性名：自定义项1
	 * 创建日期:
	 * @param newDef1 java.lang.String
	 */
	public void setDef1 (java.lang.String newDef1 ) {
	 	this.def1 = newDef1;
	} 	  
	/**
	 * 属性def2的Getter方法.属性名：自定义项2
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef2 () {
		return def2;
	}   
	/**
	 * 属性def2的Setter方法.属性名：自定义项2
	 * 创建日期:
	 * @param newDef2 java.lang.String
	 */
	public void setDef2 (java.lang.String newDef2 ) {
	 	this.def2 = newDef2;
	} 	  
	/**
	 * 属性def3的Getter方法.属性名：自定义项3
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef3 () {
		return def3;
	}   
	/**
	 * 属性def3的Setter方法.属性名：自定义项3
	 * 创建日期:
	 * @param newDef3 java.lang.String
	 */
	public void setDef3 (java.lang.String newDef3 ) {
	 	this.def3 = newDef3;
	} 	  
	/**
	 * 属性def4的Getter方法.属性名：自定义项4
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef4 () {
		return def4;
	}   
	/**
	 * 属性def4的Setter方法.属性名：自定义项4
	 * 创建日期:
	 * @param newDef4 java.lang.String
	 */
	public void setDef4 (java.lang.String newDef4 ) {
	 	this.def4 = newDef4;
	} 	  
	/**
	 * 属性def5的Getter方法.属性名：自定义项5
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef5 () {
		return def5;
	}   
	/**
	 * 属性def5的Setter方法.属性名：自定义项5
	 * 创建日期:
	 * @param newDef5 java.lang.String
	 */
	public void setDef5 (java.lang.String newDef5 ) {
	 	this.def5 = newDef5;
	} 	  
	/**
	 * 属性def6的Getter方法.属性名：自定义项6
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef6 () {
		return def6;
	}   
	/**
	 * 属性def6的Setter方法.属性名：自定义项6
	 * 创建日期:
	 * @param newDef6 java.lang.String
	 */
	public void setDef6 (java.lang.String newDef6 ) {
	 	this.def6 = newDef6;
	} 	  
	/**
	 * 属性def7的Getter方法.属性名：自定义项7
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef7 () {
		return def7;
	}   
	/**
	 * 属性def7的Setter方法.属性名：自定义项7
	 * 创建日期:
	 * @param newDef7 java.lang.String
	 */
	public void setDef7 (java.lang.String newDef7 ) {
	 	this.def7 = newDef7;
	} 	  
	/**
	 * 属性def8的Getter方法.属性名：自定义项8
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef8 () {
		return def8;
	}   
	/**
	 * 属性def8的Setter方法.属性名：自定义项8
	 * 创建日期:
	 * @param newDef8 java.lang.String
	 */
	public void setDef8 (java.lang.String newDef8 ) {
	 	this.def8 = newDef8;
	} 	  
	/**
	 * 属性def9的Getter方法.属性名：自定义项9
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef9 () {
		return def9;
	}   
	/**
	 * 属性def9的Setter方法.属性名：自定义项9
	 * 创建日期:
	 * @param newDef9 java.lang.String
	 */
	public void setDef9 (java.lang.String newDef9 ) {
	 	this.def9 = newDef9;
	} 	  
	/**
	 * 属性def10的Getter方法.属性名：自定义项10
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef10 () {
		return def10;
	}   
	/**
	 * 属性def10的Setter方法.属性名：自定义项10
	 * 创建日期:
	 * @param newDef10 java.lang.String
	 */
	public void setDef10 (java.lang.String newDef10 ) {
	 	this.def10 = newDef10;
	} 	  
	/**
	 * 属性def11的Getter方法.属性名：自定义项11
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef11 () {
		return def11;
	}   
	/**
	 * 属性def11的Setter方法.属性名：自定义项11
	 * 创建日期:
	 * @param newDef11 java.lang.String
	 */
	public void setDef11 (java.lang.String newDef11 ) {
	 	this.def11 = newDef11;
	} 	  
	/**
	 * 属性def12的Getter方法.属性名：自定义项12
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef12 () {
		return def12;
	}   
	/**
	 * 属性def12的Setter方法.属性名：自定义项12
	 * 创建日期:
	 * @param newDef12 java.lang.String
	 */
	public void setDef12 (java.lang.String newDef12 ) {
	 	this.def12 = newDef12;
	} 	  
	/**
	 * 属性def13的Getter方法.属性名：自定义项13
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef13 () {
		return def13;
	}   
	/**
	 * 属性def13的Setter方法.属性名：自定义项13
	 * 创建日期:
	 * @param newDef13 java.lang.String
	 */
	public void setDef13 (java.lang.String newDef13 ) {
	 	this.def13 = newDef13;
	} 	  
	/**
	 * 属性def14的Getter方法.属性名：自定义项14
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef14 () {
		return def14;
	}   
	/**
	 * 属性def14的Setter方法.属性名：自定义项14
	 * 创建日期:
	 * @param newDef14 java.lang.String
	 */
	public void setDef14 (java.lang.String newDef14 ) {
	 	this.def14 = newDef14;
	} 	  
	/**
	 * 属性def15的Getter方法.属性名：自定义项15
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef15 () {
		return def15;
	}   
	/**
	 * 属性def15的Setter方法.属性名：自定义项15
	 * 创建日期:
	 * @param newDef15 java.lang.String
	 */
	public void setDef15 (java.lang.String newDef15 ) {
	 	this.def15 = newDef15;
	} 	  
	/**
	 * 属性def16的Getter方法.属性名：自定义项16
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef16 () {
		return def16;
	}   
	/**
	 * 属性def16的Setter方法.属性名：自定义项16
	 * 创建日期:
	 * @param newDef16 java.lang.String
	 */
	public void setDef16 (java.lang.String newDef16 ) {
	 	this.def16 = newDef16;
	} 	  
	/**
	 * 属性def17的Getter方法.属性名：自定义项17
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef17 () {
		return def17;
	}   
	/**
	 * 属性def17的Setter方法.属性名：自定义项17
	 * 创建日期:
	 * @param newDef17 java.lang.String
	 */
	public void setDef17 (java.lang.String newDef17 ) {
	 	this.def17 = newDef17;
	} 	  
	/**
	 * 属性def18的Getter方法.属性名：自定义项18
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef18 () {
		return def18;
	}   
	/**
	 * 属性def18的Setter方法.属性名：自定义项18
	 * 创建日期:
	 * @param newDef18 java.lang.String
	 */
	public void setDef18 (java.lang.String newDef18 ) {
	 	this.def18 = newDef18;
	} 	  
	/**
	 * 属性def19的Getter方法.属性名：自定义项19
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef19 () {
		return def19;
	}   
	/**
	 * 属性def19的Setter方法.属性名：自定义项19
	 * 创建日期:
	 * @param newDef19 java.lang.String
	 */
	public void setDef19 (java.lang.String newDef19 ) {
	 	this.def19 = newDef19;
	} 	  
	/**
	 * 属性def20的Getter方法.属性名：自定义项20
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getDef20 () {
		return def20;
	}   
	/**
	 * 属性def20的Setter方法.属性名：自定义项20
	 * 创建日期:
	 * @param newDef20 java.lang.String
	 */
	public void setDef20 (java.lang.String newDef20 ) {
	 	this.def20 = newDef20;
	} 	  
	/**
	 * 属性pk_material的Getter方法.属性名：生产产品
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_material () {
		return pk_material;
	}   
	/**
	 * 属性pk_material的Setter方法.属性名：生产产品
	 * 创建日期:
	 * @param newPk_material java.lang.String
	 */
	public void setPk_material (java.lang.String newPk_material ) {
	 	this.pk_material = newPk_material;
	} 	  
	/**
	 * 属性splitstofftype的Getter方法.属性名：剖布类型
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getSplitstofftype () {
		return splitstofftype;
	}   
	/**
	 * 属性splitstofftype的Setter方法.属性名：剖布类型
	 * 创建日期:
	 * @param newSplitstofftype java.lang.String
	 */
	public void setSplitstofftype (java.lang.String newSplitstofftype ) {
	 	this.splitstofftype = newSplitstofftype;
	} 	  
	/**
	 * 属性silkwide的Getter方法.属性名：丝宽
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getSilkwide () {
		return silkwide;
	}   
	/**
	 * 属性silkwide的Setter方法.属性名：丝宽
	 * 创建日期:
	 * @param newSilkwide nc.vo.pub.lang.UFDouble
	 */
	public void setSilkwide (nc.vo.pub.lang.UFDouble newSilkwide ) {
	 	this.silkwide = newSilkwide;
	} 	  
	/**
	 * 属性elongation的Getter方法.属性名：伸长率
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getElongation () {
		return elongation;
	}   
	/**
	 * 属性elongation的Setter方法.属性名：伸长率
	 * 创建日期:
	 * @param newElongation nc.vo.pub.lang.UFDouble
	 */
	public void setElongation (nc.vo.pub.lang.UFDouble newElongation ) {
	 	this.elongation = newElongation;
	} 	  
	/**
	 * 属性tension的Getter方法.属性名：拉力
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getTension () {
		return tension;
	}   
	/**
	 * 属性tension的Setter方法.属性名：拉力
	 * 创建日期:
	 * @param newTension nc.vo.pub.lang.UFDouble
	 */
	public void setTension (nc.vo.pub.lang.UFDouble newTension ) {
	 	this.tension = newTension;
	} 	  
	/**
	 * 属性spacer的Getter方法.属性名：垫片
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public nc.vo.pub.lang.UFBoolean getSpacer () {
		return spacer;
	}   
	/**
	 * 属性spacer的Setter方法.属性名：垫片
	 * 创建日期:
	 * @param newSpacer nc.vo.pub.lang.UFBoolean
	 */
	public void setSpacer (nc.vo.pub.lang.UFBoolean newSpacer ) {
	 	this.spacer = newSpacer;
	} 	  
	/**
	 * 属性otherproduction的Getter方法.属性名：其他生产要求
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getOtherproduction () {
		return otherproduction;
	}   
	/**
	 * 属性otherproduction的Setter方法.属性名：其他生产要求
	 * 创建日期:
	 * @param newOtherproduction java.lang.String
	 */
	public void setOtherproduction (java.lang.String newOtherproduction ) {
	 	this.otherproduction = newOtherproduction;
	} 	  
	/**
	 * 属性tagline的Getter方法.属性名：标识线
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTagline () {
		return tagline;
	}   
	/**
	 * 属性tagline的Setter方法.属性名：标识线
	 * 创建日期:
	 * @param newTagline java.lang.String
	 */
	public void setTagline (java.lang.String newTagline ) {
	 	this.tagline = newTagline;
	} 	  
	/**
	 * 属性latitudedensity的Getter方法.属性名：纬密
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getLatitudedensity () {
		return latitudedensity;
	}   
	/**
	 * 属性latitudedensity的Setter方法.属性名：纬密
	 * 创建日期:
	 * @param newLatitudedensity nc.vo.pub.lang.UFDouble
	 */
	public void setLatitudedensity (nc.vo.pub.lang.UFDouble newLatitudedensity ) {
	 	this.latitudedensity = newLatitudedensity;
	} 	  
	/**
	 * 属性width的Getter方法.属性名：宽度
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getWidth () {
		return width;
	}   
	/**
	 * 属性width的Setter方法.属性名：宽度
	 * 创建日期:
	 * @param newWidth nc.vo.pub.lang.UFDouble
	 */
	public void setWidth (nc.vo.pub.lang.UFDouble newWidth ) {
	 	this.width = newWidth;
	} 	  
	/**
	 * 属性length的Getter方法.属性名：长度
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getLength () {
		return length;
	}   
	/**
	 * 属性length的Setter方法.属性名：长度
	 * 创建日期:
	 * @param newLength nc.vo.pub.lang.UFDouble
	 */
	public void setLength (nc.vo.pub.lang.UFDouble newLength ) {
	 	this.length = newLength;
	} 	  
	/**
	 * 属性pk_machine的Getter方法.属性名：生产机器
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_machine () {
		return pk_machine;
	}   
	/**
	 * 属性pk_machine的Setter方法.属性名：生产机器
	 * 创建日期:
	 * @param newPk_machine java.lang.String
	 */
	public void setPk_machine (java.lang.String newPk_machine ) {
	 	this.pk_machine = newPk_machine;
	} 	  
	/**
	 * 属性prodnum的Getter方法.属性名：本次生产数量
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getProdnum () {
		return prodnum;
	}   
	/**
	 * 属性prodnum的Setter方法.属性名：本次生产数量
	 * 创建日期:
	 * @param newProdnum nc.vo.pub.lang.UFDouble
	 */
	public void setProdnum (nc.vo.pub.lang.UFDouble newProdnum ) {
	 	this.prodnum = newProdnum;
	} 	  
	/**
	 * 属性prodnastnum的Getter方法.属性名：本次生产辅数量
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getProdnastnum () {
		return prodnastnum;
	}   
	/**
	 * 属性prodnastnum的Setter方法.属性名：本次生产辅数量
	 * 创建日期:
	 * @param newProdnastnum nc.vo.pub.lang.UFDouble
	 */
	public void setProdnastnum (nc.vo.pub.lang.UFDouble newProdnastnum ) {
	 	this.prodnastnum = newProdnastnum;
	} 	  
	/**
	 * 属性proddate的Getter方法.属性名：生产时间
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getProddate () {
		return proddate;
	}   
	/**
	 * 属性proddate的Setter方法.属性名：生产时间
	 * 创建日期:
	 * @param newProddate nc.vo.pub.lang.UFDateTime
	 */
	public void setProddate (nc.vo.pub.lang.UFDateTime newProddate ) {
	 	this.proddate = newProddate;
	} 	  
	/**
	 * 属性enddate的Getter方法.属性名：预计完工时间
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public nc.vo.pub.lang.UFDateTime getEnddate () {
		return enddate;
	}   
	/**
	 * 属性enddate的Setter方法.属性名：预计完工时间
	 * 创建日期:
	 * @param newEnddate nc.vo.pub.lang.UFDateTime
	 */
	public void setEnddate (nc.vo.pub.lang.UFDateTime newEnddate ) {
	 	this.enddate = newEnddate;
	} 	  
	/**
	 * 属性pk_bomid的Getter方法.属性名：生产BOM
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getPk_bomid () {
		return pk_bomid;
	}   
	/**
	 * 属性pk_bomid的Setter方法.属性名：生产BOM
	 * 创建日期:
	 * @param newPk_bomid java.lang.String
	 */
	public void setPk_bomid (java.lang.String newPk_bomid ) {
	 	this.pk_bomid = newPk_bomid;
	} 	  
	/**
	 * 属性vbomversion的Getter方法.属性名：生产BOM版本
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getVbomversion () {
		return vbomversion;
	}   
	/**
	 * 属性vbomversion的Setter方法.属性名：生产BOM版本
	 * 创建日期:
	 * @param newVbomversion java.lang.String
	 */
	public void setVbomversion (java.lang.String newVbomversion ) {
	 	this.vbomversion = newVbomversion;
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
	 * 属性sfmakebill的Getter方法.属性名：是否生成生产订单
	 * 创建日期:
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public nc.vo.pub.lang.UFBoolean getSfmakebill () {
		return sfmakebill;
	}   
	/**
	 * 属性sfmakebill的Setter方法.属性名：是否生成生产订单
	 * 创建日期:
	 * @param newSfmakebill nc.vo.pub.lang.UFBoolean
	 */
	public void setSfmakebill (nc.vo.pub.lang.UFBoolean newSfmakebill ) {
	 	this.sfmakebill = newSfmakebill;
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
	  return "pk_rdpd";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "so_rdpd";
	}    
	
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	public static java.lang.String getDefaultTableName() {
		return "so_rdpd";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:
	  */
     public RdPorductDetailVO() {
		super();	
	}    
	
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.so.qs.sc.RdPorductDetailVO" )
	public IVOMeta getMetaData() {
   		return null;
  	}
} 


