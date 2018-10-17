package nc.vo.so.qs.sc;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class ShipmentsBVO extends SuperVO {
/**
*��Ʒ
*/
public UFBoolean blargessflag;
/**
*�Ƿ��йر�
*/
public UFBoolean blineclose;
/**
*Ӧ����֯���°汾
*/
public String carorgid;
/**
*Ӧ����֯
*/
public String carorgvid;
/**
*�������
*/
public String carrangeid;
/**
*����λ
*/
public String castunitid;
/**
*��Ʒ����
*/
public String cateralvid;
/**
*Դͷ�����ӱ�
*/
public String cfirstbid;
/**
*Դͷ��������
*/
public String cfirstid;
/**
*���ϵ���
*/
public String cmaterialid;
/**
*�۸���Ŀ
*/
public String cpriceitemid;
/**
*�۸��
*/
public String cpriceitemtableid;
/**
*�۸�����
*/
public String cpricepolicyid;
/**
*�����������°汾
*/
public String cprofitcenterid;
/**
*��������
*/
public String cprofitcentervid;
/**
*�ջ���ַ
*/
public String creceiveaddrid;
/**
*�ջ�����
*/
public String creceiveareaid;
/**
*�ջ��ͻ�
*/
public String creceivecustid;
/**
*�ջ��ص�
*/
public String creceivesiteid;
/**
*�ϱ�
*/
public String csbomversionid;
/**
*���������֯���°汾
*/
public String csendstockorgid;
/**
*���������֯
*/
public String csendstockorgvid;
/**
*�����ֿ�
*/
public String csendstordocid;
/**
*���������֯���°汾
*/
public String csettleorgid;
/**
*���������֯
*/
public String csettleorgvid;
/**
*��Դ���ݸ���
*/
public String csrcbid;
/**
*��Դ��������
*/
public String csrcid;
/**
*������֯���°汾
*/
public String ctrafficorgid;
/**
*������֯
*/
public String ctrafficorgvid;
/**
*����λ
*/
public String cunitid;
/**
*�ʲ�����
*/
public String cutcloth;
/**
*���������
*/
public UFDate darrdate;
/**
*�Զ�����1
*/
public String def1;
/**
*�Զ�����10
*/
public String def10;
/**
*�Զ�����11
*/
public String def11;
/**
*�Զ�����12
*/
public String def12;
/**
*�Զ�����13
*/
public String def13;
/**
*�Զ�����14
*/
public String def14;
/**
*�Զ�����15
*/
public String def15;
/**
*�Զ�����16
*/
public String def16;
/**
*�Զ�����17
*/
public String def17;
/**
*�Զ�����18
*/
public String def18;
/**
*�Զ�����19
*/
public String def19;
/**
*�Զ�����2
*/
public String def2;
/**
*�Զ�����20
*/
public String def20;
/**
*�Զ�����3
*/
public String def3;
/**
*�Զ�����4
*/
public String def4;
/**
*�Զ�����5
*/
public String def5;
/**
*�Զ�����6
*/
public String def6;
/**
*�Զ�����7
*/
public String def7;
/**
*�Զ�����8
*/
public String def8;
/**
*�Զ�����9
*/
public String def9;
/**
*Ҫ�󵽻�����
*/
public UFDate dreceivedate;
/**
*�ƻ���������
*/
public UFDate dsenddate;
/**
*����
*/
public UFDouble earnestmoney;
/**
*��˰���
*/
public Integer ftaxtypeflag;
/**
*����
*/
public UFDouble listprice;
/**
*��Ʒ�������
*/
public String marbasclassid;
/**
*��ע
*/
public String memo;
/**
*����ϼ�
*/
public UFDouble mixtureprice;
/**
*�ۼư�������
*/
public UFDouble narrnum;
/**
*������
*/
public UFDouble nastnum;
/**
*������
*/
public UFDouble nnum;
/**
*��˰���
*/
public UFDouble norigmny;
/**
*��˰����
*/
public UFDouble norigprice;
/**
*��˰�ϼ�
*/
public UFDouble norigtaxmny;
/**
*��˰����
*/
public UFDouble norigtaxprice;
/**
*����˰����
*/
public UFDouble nqtorigprice;
/**
*����˰����
*/
public UFDouble nqtorigtaxprice;
/**
*˰��
*/
public UFDouble ntax;
/**
*˰��
*/
public UFDouble ntaxrate;
/**
*��������Ҫ��
*/
public String otherproduction;
/**
*������(KG)
*/
public String packageweight;
/**
*���ε���
*/
public String pk_batchcode;
/**
*����
*/
public String pk_group;
/**
*������֯
*/
public String pk_org;
/**
*��������������
*/
public String pk_shipments_b;
/**
*�к�
*/
public String rowno;
/**
*�ϲ㵥������
*/
public String so_shipmentsb;
/**
*��ʶ��
*/
public String tagline;
/**
*ʱ���
*/
public UFDateTime ts;
/**
*���κ�
*/
public String vbatchcode;
/**
*������
*/
public String vchangerate;
/**
*Դͷ���ݺ�
*/
public String vfirstcode;
/**
*Դͷ�����к�
*/
public String vfirstrowno;
/**
*Դͷ��������
*/
public String vfirsttrantype;
/**
*Դͷ��������
*/
public String vfirsttype;
/**
*���ɸ�������1
*/
public String vfree1;
/**
*���ɸ�������10
*/
public String vfree10;
/**
*���ɸ�������2
*/
public String vfree2;
/**
*���ɸ�������3
*/
public String vfree3;
/**
*���ɸ�������4
*/
public String vfree4;
/**
*���ɸ�������5
*/
public String vfree5;
/**
*���ɸ�������6
*/
public String vfree6;
/**
*���ɸ�������7
*/
public String vfree7;
/**
*���ɸ�������8
*/
public String vfree8;
/**
*���ɸ�������9
*/
public String vfree9;
/**
*��Դ���ݺ�
*/
public String vsrccode;
/**
*��Դ�����к�
*/
public String vsrcrowno;
/**
*��Դ��������
*/
public String vsrctrantype;
/**
*��Դ��������
*/
public String vsrctype;
/** 
* ��ȡ��Ʒ
*
* @return ��Ʒ
*/
public UFBoolean getBlargessflag () {
return this.blargessflag;
 } 

/** 
* ������Ʒ
*
* @param blargessflag ��Ʒ
*/
public void setBlargessflag ( UFBoolean blargessflag) {
this.blargessflag=blargessflag;
 } 

/** 
* ��ȡ�Ƿ��йر�
*
* @return �Ƿ��йر�
*/
public UFBoolean getBlineclose () {
return this.blineclose;
 } 

/** 
* �����Ƿ��йر�
*
* @param blineclose �Ƿ��йر�
*/
public void setBlineclose ( UFBoolean blineclose) {
this.blineclose=blineclose;
 } 

/** 
* ��ȡӦ����֯���°汾
*
* @return Ӧ����֯���°汾
*/
public String getCarorgid () {
return this.carorgid;
 } 

/** 
* ����Ӧ����֯���°汾
*
* @param carorgid Ӧ����֯���°汾
*/
public void setCarorgid ( String carorgid) {
this.carorgid=carorgid;
 } 

/** 
* ��ȡӦ����֯
*
* @return Ӧ����֯
*/
public String getCarorgvid () {
return this.carorgvid;
 } 

/** 
* ����Ӧ����֯
*
* @param carorgvid Ӧ����֯
*/
public void setCarorgvid ( String carorgvid) {
this.carorgvid=carorgvid;
 } 

/** 
* ��ȡ�������
*
* @return �������
*/
public String getCarrangeid () {
return this.carrangeid;
 } 

/** 
* �����������
*
* @param carrangeid �������
*/
public void setCarrangeid ( String carrangeid) {
this.carrangeid=carrangeid;
 } 

/** 
* ��ȡ����λ
*
* @return ����λ
*/
public String getCastunitid () {
return this.castunitid;
 } 

/** 
* ���ø���λ
*
* @param castunitid ����λ
*/
public void setCastunitid ( String castunitid) {
this.castunitid=castunitid;
 } 

/** 
* ��ȡ��Ʒ����
*
* @return ��Ʒ����
*/
public String getCateralvid () {
return this.cateralvid;
 } 

/** 
* ���ò�Ʒ����
*
* @param cateralvid ��Ʒ����
*/
public void setCateralvid ( String cateralvid) {
this.cateralvid=cateralvid;
 } 

/** 
* ��ȡԴͷ�����ӱ�
*
* @return Դͷ�����ӱ�
*/
public String getCfirstbid () {
return this.cfirstbid;
 } 

/** 
* ����Դͷ�����ӱ�
*
* @param cfirstbid Դͷ�����ӱ�
*/
public void setCfirstbid ( String cfirstbid) {
this.cfirstbid=cfirstbid;
 } 

/** 
* ��ȡԴͷ��������
*
* @return Դͷ��������
*/
public String getCfirstid () {
return this.cfirstid;
 } 

/** 
* ����Դͷ��������
*
* @param cfirstid Դͷ��������
*/
public void setCfirstid ( String cfirstid) {
this.cfirstid=cfirstid;
 } 

/** 
* ��ȡ���ϵ���
*
* @return ���ϵ���
*/
public String getCmaterialid () {
return this.cmaterialid;
 } 

/** 
* �������ϵ���
*
* @param cmaterialid ���ϵ���
*/
public void setCmaterialid ( String cmaterialid) {
this.cmaterialid=cmaterialid;
 } 

/** 
* ��ȡ�۸���Ŀ
*
* @return �۸���Ŀ
*/
public String getCpriceitemid () {
return this.cpriceitemid;
 } 

/** 
* ���ü۸���Ŀ
*
* @param cpriceitemid �۸���Ŀ
*/
public void setCpriceitemid ( String cpriceitemid) {
this.cpriceitemid=cpriceitemid;
 } 

/** 
* ��ȡ�۸��
*
* @return �۸��
*/
public String getCpriceitemtableid () {
return this.cpriceitemtableid;
 } 

/** 
* ���ü۸��
*
* @param cpriceitemtableid �۸��
*/
public void setCpriceitemtableid ( String cpriceitemtableid) {
this.cpriceitemtableid=cpriceitemtableid;
 } 

/** 
* ��ȡ�۸�����
*
* @return �۸�����
*/
public String getCpricepolicyid () {
return this.cpricepolicyid;
 } 

/** 
* ���ü۸�����
*
* @param cpricepolicyid �۸�����
*/
public void setCpricepolicyid ( String cpricepolicyid) {
this.cpricepolicyid=cpricepolicyid;
 } 

/** 
* ��ȡ�����������°汾
*
* @return �����������°汾
*/
public String getCprofitcenterid () {
return this.cprofitcenterid;
 } 

/** 
* ���������������°汾
*
* @param cprofitcenterid �����������°汾
*/
public void setCprofitcenterid ( String cprofitcenterid) {
this.cprofitcenterid=cprofitcenterid;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public String getCprofitcentervid () {
return this.cprofitcentervid;
 } 

/** 
* ������������
*
* @param cprofitcentervid ��������
*/
public void setCprofitcentervid ( String cprofitcentervid) {
this.cprofitcentervid=cprofitcentervid;
 } 

/** 
* ��ȡ�ջ���ַ
*
* @return �ջ���ַ
*/
public String getCreceiveaddrid () {
return this.creceiveaddrid;
 } 

/** 
* �����ջ���ַ
*
* @param creceiveaddrid �ջ���ַ
*/
public void setCreceiveaddrid ( String creceiveaddrid) {
this.creceiveaddrid=creceiveaddrid;
 } 

/** 
* ��ȡ�ջ�����
*
* @return �ջ�����
*/
public String getCreceiveareaid () {
return this.creceiveareaid;
 } 

/** 
* �����ջ�����
*
* @param creceiveareaid �ջ�����
*/
public void setCreceiveareaid ( String creceiveareaid) {
this.creceiveareaid=creceiveareaid;
 } 

/** 
* ��ȡ�ջ��ͻ�
*
* @return �ջ��ͻ�
*/
public String getCreceivecustid () {
return this.creceivecustid;
 } 

/** 
* �����ջ��ͻ�
*
* @param creceivecustid �ջ��ͻ�
*/
public void setCreceivecustid ( String creceivecustid) {
this.creceivecustid=creceivecustid;
 } 

/** 
* ��ȡ�ջ��ص�
*
* @return �ջ��ص�
*/
public String getCreceivesiteid () {
return this.creceivesiteid;
 } 

/** 
* �����ջ��ص�
*
* @param creceivesiteid �ջ��ص�
*/
public void setCreceivesiteid ( String creceivesiteid) {
this.creceivesiteid=creceivesiteid;
 } 

/** 
* ��ȡ�ϱ�
*
* @return �ϱ�
*/
public String getCsbomversionid () {
return this.csbomversionid;
 } 

/** 
* �����ϱ�
*
* @param csbomversionid �ϱ�
*/
public void setCsbomversionid ( String csbomversionid) {
this.csbomversionid=csbomversionid;
 } 

/** 
* ��ȡ���������֯���°汾
*
* @return ���������֯���°汾
*/
public String getCsendstockorgid () {
return this.csendstockorgid;
 } 

/** 
* ���÷��������֯���°汾
*
* @param csendstockorgid ���������֯���°汾
*/
public void setCsendstockorgid ( String csendstockorgid) {
this.csendstockorgid=csendstockorgid;
 } 

/** 
* ��ȡ���������֯
*
* @return ���������֯
*/
public String getCsendstockorgvid () {
return this.csendstockorgvid;
 } 

/** 
* ���÷��������֯
*
* @param csendstockorgvid ���������֯
*/
public void setCsendstockorgvid ( String csendstockorgvid) {
this.csendstockorgvid=csendstockorgvid;
 } 

/** 
* ��ȡ�����ֿ�
*
* @return �����ֿ�
*/
public String getCsendstordocid () {
return this.csendstordocid;
 } 

/** 
* ���÷����ֿ�
*
* @param csendstordocid �����ֿ�
*/
public void setCsendstordocid ( String csendstordocid) {
this.csendstordocid=csendstordocid;
 } 

/** 
* ��ȡ���������֯���°汾
*
* @return ���������֯���°汾
*/
public String getCsettleorgid () {
return this.csettleorgid;
 } 

/** 
* ���ý��������֯���°汾
*
* @param csettleorgid ���������֯���°汾
*/
public void setCsettleorgid ( String csettleorgid) {
this.csettleorgid=csettleorgid;
 } 

/** 
* ��ȡ���������֯
*
* @return ���������֯
*/
public String getCsettleorgvid () {
return this.csettleorgvid;
 } 

/** 
* ���ý��������֯
*
* @param csettleorgvid ���������֯
*/
public void setCsettleorgvid ( String csettleorgvid) {
this.csettleorgvid=csettleorgvid;
 } 

/** 
* ��ȡ��Դ���ݸ���
*
* @return ��Դ���ݸ���
*/
public String getCsrcbid () {
return this.csrcbid;
 } 

/** 
* ������Դ���ݸ���
*
* @param csrcbid ��Դ���ݸ���
*/
public void setCsrcbid ( String csrcbid) {
this.csrcbid=csrcbid;
 } 

/** 
* ��ȡ��Դ��������
*
* @return ��Դ��������
*/
public String getCsrcid () {
return this.csrcid;
 } 

/** 
* ������Դ��������
*
* @param csrcid ��Դ��������
*/
public void setCsrcid ( String csrcid) {
this.csrcid=csrcid;
 } 

/** 
* ��ȡ������֯���°汾
*
* @return ������֯���°汾
*/
public String getCtrafficorgid () {
return this.ctrafficorgid;
 } 

/** 
* ����������֯���°汾
*
* @param ctrafficorgid ������֯���°汾
*/
public void setCtrafficorgid ( String ctrafficorgid) {
this.ctrafficorgid=ctrafficorgid;
 } 

/** 
* ��ȡ������֯
*
* @return ������֯
*/
public String getCtrafficorgvid () {
return this.ctrafficorgvid;
 } 

/** 
* ����������֯
*
* @param ctrafficorgvid ������֯
*/
public void setCtrafficorgvid ( String ctrafficorgvid) {
this.ctrafficorgvid=ctrafficorgvid;
 } 

/** 
* ��ȡ����λ
*
* @return ����λ
*/
public String getCunitid () {
return this.cunitid;
 } 

/** 
* ��������λ
*
* @param cunitid ����λ
*/
public void setCunitid ( String cunitid) {
this.cunitid=cunitid;
 } 

/** 
* ��ȡ�ʲ�����
*
* @return �ʲ�����
*/
public String getCutcloth () {
return this.cutcloth;
 } 

/** 
* �����ʲ�����
*
* @param cutcloth �ʲ�����
*/
public void setCutcloth ( String cutcloth) {
this.cutcloth=cutcloth;
 } 

/** 
* ��ȡ���������
*
* @return ���������
*/
public UFDate getDarrdate () {
return this.darrdate;
 } 

/** 
* �������������
*
* @param darrdate ���������
*/
public void setDarrdate ( UFDate darrdate) {
this.darrdate=darrdate;
 } 

/** 
* ��ȡ�Զ�����1
*
* @return �Զ�����1
*/
public String getDef1 () {
return this.def1;
 } 

/** 
* �����Զ�����1
*
* @param def1 �Զ�����1
*/
public void setDef1 ( String def1) {
this.def1=def1;
 } 

/** 
* ��ȡ�Զ�����10
*
* @return �Զ�����10
*/
public String getDef10 () {
return this.def10;
 } 

/** 
* �����Զ�����10
*
* @param def10 �Զ�����10
*/
public void setDef10 ( String def10) {
this.def10=def10;
 } 

/** 
* ��ȡ�Զ�����11
*
* @return �Զ�����11
*/
public String getDef11 () {
return this.def11;
 } 

/** 
* �����Զ�����11
*
* @param def11 �Զ�����11
*/
public void setDef11 ( String def11) {
this.def11=def11;
 } 

/** 
* ��ȡ�Զ�����12
*
* @return �Զ�����12
*/
public String getDef12 () {
return this.def12;
 } 

/** 
* �����Զ�����12
*
* @param def12 �Զ�����12
*/
public void setDef12 ( String def12) {
this.def12=def12;
 } 

/** 
* ��ȡ�Զ�����13
*
* @return �Զ�����13
*/
public String getDef13 () {
return this.def13;
 } 

/** 
* �����Զ�����13
*
* @param def13 �Զ�����13
*/
public void setDef13 ( String def13) {
this.def13=def13;
 } 

/** 
* ��ȡ�Զ�����14
*
* @return �Զ�����14
*/
public String getDef14 () {
return this.def14;
 } 

/** 
* �����Զ�����14
*
* @param def14 �Զ�����14
*/
public void setDef14 ( String def14) {
this.def14=def14;
 } 

/** 
* ��ȡ�Զ�����15
*
* @return �Զ�����15
*/
public String getDef15 () {
return this.def15;
 } 

/** 
* �����Զ�����15
*
* @param def15 �Զ�����15
*/
public void setDef15 ( String def15) {
this.def15=def15;
 } 

/** 
* ��ȡ�Զ�����16
*
* @return �Զ�����16
*/
public String getDef16 () {
return this.def16;
 } 

/** 
* �����Զ�����16
*
* @param def16 �Զ�����16
*/
public void setDef16 ( String def16) {
this.def16=def16;
 } 

/** 
* ��ȡ�Զ�����17
*
* @return �Զ�����17
*/
public String getDef17 () {
return this.def17;
 } 

/** 
* �����Զ�����17
*
* @param def17 �Զ�����17
*/
public void setDef17 ( String def17) {
this.def17=def17;
 } 

/** 
* ��ȡ�Զ�����18
*
* @return �Զ�����18
*/
public String getDef18 () {
return this.def18;
 } 

/** 
* �����Զ�����18
*
* @param def18 �Զ�����18
*/
public void setDef18 ( String def18) {
this.def18=def18;
 } 

/** 
* ��ȡ�Զ�����19
*
* @return �Զ�����19
*/
public String getDef19 () {
return this.def19;
 } 

/** 
* �����Զ�����19
*
* @param def19 �Զ�����19
*/
public void setDef19 ( String def19) {
this.def19=def19;
 } 

/** 
* ��ȡ�Զ�����2
*
* @return �Զ�����2
*/
public String getDef2 () {
return this.def2;
 } 

/** 
* �����Զ�����2
*
* @param def2 �Զ�����2
*/
public void setDef2 ( String def2) {
this.def2=def2;
 } 

/** 
* ��ȡ�Զ�����20
*
* @return �Զ�����20
*/
public String getDef20 () {
return this.def20;
 } 

/** 
* �����Զ�����20
*
* @param def20 �Զ�����20
*/
public void setDef20 ( String def20) {
this.def20=def20;
 } 

/** 
* ��ȡ�Զ�����3
*
* @return �Զ�����3
*/
public String getDef3 () {
return this.def3;
 } 

/** 
* �����Զ�����3
*
* @param def3 �Զ�����3
*/
public void setDef3 ( String def3) {
this.def3=def3;
 } 

/** 
* ��ȡ�Զ�����4
*
* @return �Զ�����4
*/
public String getDef4 () {
return this.def4;
 } 

/** 
* �����Զ�����4
*
* @param def4 �Զ�����4
*/
public void setDef4 ( String def4) {
this.def4=def4;
 } 

/** 
* ��ȡ�Զ�����5
*
* @return �Զ�����5
*/
public String getDef5 () {
return this.def5;
 } 

/** 
* �����Զ�����5
*
* @param def5 �Զ�����5
*/
public void setDef5 ( String def5) {
this.def5=def5;
 } 

/** 
* ��ȡ�Զ�����6
*
* @return �Զ�����6
*/
public String getDef6 () {
return this.def6;
 } 

/** 
* �����Զ�����6
*
* @param def6 �Զ�����6
*/
public void setDef6 ( String def6) {
this.def6=def6;
 } 

/** 
* ��ȡ�Զ�����7
*
* @return �Զ�����7
*/
public String getDef7 () {
return this.def7;
 } 

/** 
* �����Զ�����7
*
* @param def7 �Զ�����7
*/
public void setDef7 ( String def7) {
this.def7=def7;
 } 

/** 
* ��ȡ�Զ�����8
*
* @return �Զ�����8
*/
public String getDef8 () {
return this.def8;
 } 

/** 
* �����Զ�����8
*
* @param def8 �Զ�����8
*/
public void setDef8 ( String def8) {
this.def8=def8;
 } 

/** 
* ��ȡ�Զ�����9
*
* @return �Զ�����9
*/
public String getDef9 () {
return this.def9;
 } 

/** 
* �����Զ�����9
*
* @param def9 �Զ�����9
*/
public void setDef9 ( String def9) {
this.def9=def9;
 } 

/** 
* ��ȡҪ�󵽻�����
*
* @return Ҫ�󵽻�����
*/
public UFDate getDreceivedate () {
return this.dreceivedate;
 } 

/** 
* ����Ҫ�󵽻�����
*
* @param dreceivedate Ҫ�󵽻�����
*/
public void setDreceivedate ( UFDate dreceivedate) {
this.dreceivedate=dreceivedate;
 } 

/** 
* ��ȡ�ƻ���������
*
* @return �ƻ���������
*/
public UFDate getDsenddate () {
return this.dsenddate;
 } 

/** 
* ���üƻ���������
*
* @param dsenddate �ƻ���������
*/
public void setDsenddate ( UFDate dsenddate) {
this.dsenddate=dsenddate;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public UFDouble getEarnestmoney () {
return this.earnestmoney;
 } 

/** 
* ���ö���
*
* @param earnestmoney ����
*/
public void setEarnestmoney ( UFDouble earnestmoney) {
this.earnestmoney=earnestmoney;
 } 

/** 
* ��ȡ��˰���
*
* @return ��˰���
* @see String
*/
public Integer getFtaxtypeflag () {
return this.ftaxtypeflag;
 } 

/** 
* ���ÿ�˰���
*
* @param ftaxtypeflag ��˰���
* @see String
*/
public void setFtaxtypeflag ( Integer ftaxtypeflag) {
this.ftaxtypeflag=ftaxtypeflag;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public UFDouble getListprice () {
return this.listprice;
 } 

/** 
* ���ö���
*
* @param listprice ����
*/
public void setListprice ( UFDouble listprice) {
this.listprice=listprice;
 } 

/** 
* ��ȡ��Ʒ�������
*
* @return ��Ʒ�������
*/
public String getMarbasclassid () {
return this.marbasclassid;
 } 

/** 
* ���ò�Ʒ�������
*
* @param marbasclassid ��Ʒ�������
*/
public void setMarbasclassid ( String marbasclassid) {
this.marbasclassid=marbasclassid;
 } 

/** 
* ��ȡ��ע
*
* @return ��ע
*/
public String getMemo () {
return this.memo;
 } 

/** 
* ���ñ�ע
*
* @param memo ��ע
*/
public void setMemo ( String memo) {
this.memo=memo;
 } 

/** 
* ��ȡ����ϼ�
*
* @return ����ϼ�
*/
public UFDouble getMixtureprice () {
return this.mixtureprice;
 } 

/** 
* ���û���ϼ�
*
* @param mixtureprice ����ϼ�
*/
public void setMixtureprice ( UFDouble mixtureprice) {
this.mixtureprice=mixtureprice;
 } 

/** 
* ��ȡ�ۼư�������
*
* @return �ۼư�������
*/
public UFDouble getNarrnum () {
return this.narrnum;
 } 

/** 
* �����ۼư�������
*
* @param narrnum �ۼư�������
*/
public void setNarrnum ( UFDouble narrnum) {
this.narrnum=narrnum;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public UFDouble getNastnum () {
return this.nastnum;
 } 

/** 
* ���ø�����
*
* @param nastnum ������
*/
public void setNastnum ( UFDouble nastnum) {
this.nastnum=nastnum;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public UFDouble getNnum () {
return this.nnum;
 } 

/** 
* ����������
*
* @param nnum ������
*/
public void setNnum ( UFDouble nnum) {
this.nnum=nnum;
 } 

/** 
* ��ȡ��˰���
*
* @return ��˰���
*/
public UFDouble getNorigmny () {
return this.norigmny;
 } 

/** 
* ������˰���
*
* @param norigmny ��˰���
*/
public void setNorigmny ( UFDouble norigmny) {
this.norigmny=norigmny;
 } 

/** 
* ��ȡ��˰����
*
* @return ��˰����
*/
public UFDouble getNorigprice () {
return this.norigprice;
 } 

/** 
* ������˰����
*
* @param norigprice ��˰����
*/
public void setNorigprice ( UFDouble norigprice) {
this.norigprice=norigprice;
 } 

/** 
* ��ȡ��˰�ϼ�
*
* @return ��˰�ϼ�
*/
public UFDouble getNorigtaxmny () {
return this.norigtaxmny;
 } 

/** 
* ���ü�˰�ϼ�
*
* @param norigtaxmny ��˰�ϼ�
*/
public void setNorigtaxmny ( UFDouble norigtaxmny) {
this.norigtaxmny=norigtaxmny;
 } 

/** 
* ��ȡ��˰����
*
* @return ��˰����
*/
public UFDouble getNorigtaxprice () {
return this.norigtaxprice;
 } 

/** 
* ���ú�˰����
*
* @param norigtaxprice ��˰����
*/
public void setNorigtaxprice ( UFDouble norigtaxprice) {
this.norigtaxprice=norigtaxprice;
 } 

/** 
* ��ȡ����˰����
*
* @return ����˰����
*/
public UFDouble getNqtorigprice () {
return this.nqtorigprice;
 } 

/** 
* ���ø���˰����
*
* @param nqtorigprice ����˰����
*/
public void setNqtorigprice ( UFDouble nqtorigprice) {
this.nqtorigprice=nqtorigprice;
 } 

/** 
* ��ȡ����˰����
*
* @return ����˰����
*/
public UFDouble getNqtorigtaxprice () {
return this.nqtorigtaxprice;
 } 

/** 
* ���ø���˰����
*
* @param nqtorigtaxprice ����˰����
*/
public void setNqtorigtaxprice ( UFDouble nqtorigtaxprice) {
this.nqtorigtaxprice=nqtorigtaxprice;
 } 

/** 
* ��ȡ˰��
*
* @return ˰��
*/
public UFDouble getNtax () {
return this.ntax;
 } 

/** 
* ����˰��
*
* @param ntax ˰��
*/
public void setNtax ( UFDouble ntax) {
this.ntax=ntax;
 } 

/** 
* ��ȡ˰��
*
* @return ˰��
*/
public UFDouble getNtaxrate () {
return this.ntaxrate;
 } 

/** 
* ����˰��
*
* @param ntaxrate ˰��
*/
public void setNtaxrate ( UFDouble ntaxrate) {
this.ntaxrate=ntaxrate;
 } 

/** 
* ��ȡ��������Ҫ��
*
* @return ��������Ҫ��
*/
public String getOtherproduction () {
return this.otherproduction;
 } 

/** 
* ������������Ҫ��
*
* @param otherproduction ��������Ҫ��
*/
public void setOtherproduction ( String otherproduction) {
this.otherproduction=otherproduction;
 } 

/** 
* ��ȡ������(KG)
*
* @return ������(KG)
*/
public String getPackageweight () {
return this.packageweight;
 } 

/** 
* ���õ�����(KG)
*
* @param packageweight ������(KG)
*/
public void setPackageweight ( String packageweight) {
this.packageweight=packageweight;
 } 

/** 
* ��ȡ���ε���
*
* @return ���ε���
*/
public String getPk_batchcode () {
return this.pk_batchcode;
 } 

/** 
* �������ε���
*
* @param pk_batchcode ���ε���
*/
public void setPk_batchcode ( String pk_batchcode) {
this.pk_batchcode=pk_batchcode;
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk_group () {
return this.pk_group;
 } 

/** 
* ���ü���
*
* @param pk_group ����
*/
public void setPk_group ( String pk_group) {
this.pk_group=pk_group;
 } 

/** 
* ��ȡ������֯
*
* @return ������֯
*/
public String getPk_org () {
return this.pk_org;
 } 

/** 
* ����������֯
*
* @param pk_org ������֯
*/
public void setPk_org ( String pk_org) {
this.pk_org=pk_org;
 } 

/** 
* ��ȡ��������������
*
* @return ��������������
*/
public String getPk_shipments_b () {
return this.pk_shipments_b;
 } 

/** 
* ���÷�������������
*
* @param pk_shipments_b ��������������
*/
public void setPk_shipments_b ( String pk_shipments_b) {
this.pk_shipments_b=pk_shipments_b;
 } 

/** 
* ��ȡ�к�
*
* @return �к�
*/
public String getRowno () {
return this.rowno;
 } 

/** 
* �����к�
*
* @param rowno �к�
*/
public void setRowno ( String rowno) {
this.rowno=rowno;
 } 

/** 
* ��ȡ�ϲ㵥������
*
* @return �ϲ㵥������
*/
public String getSo_shipmentsb () {
return this.so_shipmentsb;
 } 

/** 
* �����ϲ㵥������
*
* @param so_shipmentsb �ϲ㵥������
*/
public void setSo_shipmentsb ( String so_shipmentsb) {
this.so_shipmentsb=so_shipmentsb;
 } 

/** 
* ��ȡ��ʶ��
*
* @return ��ʶ��
*/
public String getTagline () {
return this.tagline;
 } 

/** 
* ���ñ�ʶ��
*
* @param tagline ��ʶ��
*/
public void setTagline ( String tagline) {
this.tagline=tagline;
 } 

/** 
* ��ȡʱ���
*
* @return ʱ���
*/
public UFDateTime getTs () {
return this.ts;
 } 

/** 
* ����ʱ���
*
* @param ts ʱ���
*/
public void setTs ( UFDateTime ts) {
this.ts=ts;
 } 

/** 
* ��ȡ���κ�
*
* @return ���κ�
*/
public String getVbatchcode () {
return this.vbatchcode;
 } 

/** 
* �������κ�
*
* @param vbatchcode ���κ�
*/
public void setVbatchcode ( String vbatchcode) {
this.vbatchcode=vbatchcode;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getVchangerate () {
return this.vchangerate;
 } 

/** 
* ���û�����
*
* @param vchangerate ������
*/
public void setVchangerate ( String vchangerate) {
this.vchangerate=vchangerate;
 } 

/** 
* ��ȡԴͷ���ݺ�
*
* @return Դͷ���ݺ�
*/
public String getVfirstcode () {
return this.vfirstcode;
 } 

/** 
* ����Դͷ���ݺ�
*
* @param vfirstcode Դͷ���ݺ�
*/
public void setVfirstcode ( String vfirstcode) {
this.vfirstcode=vfirstcode;
 } 

/** 
* ��ȡԴͷ�����к�
*
* @return Դͷ�����к�
*/
public String getVfirstrowno () {
return this.vfirstrowno;
 } 

/** 
* ����Դͷ�����к�
*
* @param vfirstrowno Դͷ�����к�
*/
public void setVfirstrowno ( String vfirstrowno) {
this.vfirstrowno=vfirstrowno;
 } 

/** 
* ��ȡԴͷ��������
*
* @return Դͷ��������
*/
public String getVfirsttrantype () {
return this.vfirsttrantype;
 } 

/** 
* ����Դͷ��������
*
* @param vfirsttrantype Դͷ��������
*/
public void setVfirsttrantype ( String vfirsttrantype) {
this.vfirsttrantype=vfirsttrantype;
 } 

/** 
* ��ȡԴͷ��������
*
* @return Դͷ��������
*/
public String getVfirsttype () {
return this.vfirsttype;
 } 

/** 
* ����Դͷ��������
*
* @param vfirsttype Դͷ��������
*/
public void setVfirsttype ( String vfirsttype) {
this.vfirsttype=vfirsttype;
 } 

/** 
* ��ȡ���ɸ�������1
*
* @return ���ɸ�������1
*/
public String getVfree1 () {
return this.vfree1;
 } 

/** 
* �������ɸ�������1
*
* @param vfree1 ���ɸ�������1
*/
public void setVfree1 ( String vfree1) {
this.vfree1=vfree1;
 } 

/** 
* ��ȡ���ɸ�������10
*
* @return ���ɸ�������10
*/
public String getVfree10 () {
return this.vfree10;
 } 

/** 
* �������ɸ�������10
*
* @param vfree10 ���ɸ�������10
*/
public void setVfree10 ( String vfree10) {
this.vfree10=vfree10;
 } 

/** 
* ��ȡ���ɸ�������2
*
* @return ���ɸ�������2
*/
public String getVfree2 () {
return this.vfree2;
 } 

/** 
* �������ɸ�������2
*
* @param vfree2 ���ɸ�������2
*/
public void setVfree2 ( String vfree2) {
this.vfree2=vfree2;
 } 

/** 
* ��ȡ���ɸ�������3
*
* @return ���ɸ�������3
*/
public String getVfree3 () {
return this.vfree3;
 } 

/** 
* �������ɸ�������3
*
* @param vfree3 ���ɸ�������3
*/
public void setVfree3 ( String vfree3) {
this.vfree3=vfree3;
 } 

/** 
* ��ȡ���ɸ�������4
*
* @return ���ɸ�������4
*/
public String getVfree4 () {
return this.vfree4;
 } 

/** 
* �������ɸ�������4
*
* @param vfree4 ���ɸ�������4
*/
public void setVfree4 ( String vfree4) {
this.vfree4=vfree4;
 } 

/** 
* ��ȡ���ɸ�������5
*
* @return ���ɸ�������5
*/
public String getVfree5 () {
return this.vfree5;
 } 

/** 
* �������ɸ�������5
*
* @param vfree5 ���ɸ�������5
*/
public void setVfree5 ( String vfree5) {
this.vfree5=vfree5;
 } 

/** 
* ��ȡ���ɸ�������6
*
* @return ���ɸ�������6
*/
public String getVfree6 () {
return this.vfree6;
 } 

/** 
* �������ɸ�������6
*
* @param vfree6 ���ɸ�������6
*/
public void setVfree6 ( String vfree6) {
this.vfree6=vfree6;
 } 

/** 
* ��ȡ���ɸ�������7
*
* @return ���ɸ�������7
*/
public String getVfree7 () {
return this.vfree7;
 } 

/** 
* �������ɸ�������7
*
* @param vfree7 ���ɸ�������7
*/
public void setVfree7 ( String vfree7) {
this.vfree7=vfree7;
 } 

/** 
* ��ȡ���ɸ�������8
*
* @return ���ɸ�������8
*/
public String getVfree8 () {
return this.vfree8;
 } 

/** 
* �������ɸ�������8
*
* @param vfree8 ���ɸ�������8
*/
public void setVfree8 ( String vfree8) {
this.vfree8=vfree8;
 } 

/** 
* ��ȡ���ɸ�������9
*
* @return ���ɸ�������9
*/
public String getVfree9 () {
return this.vfree9;
 } 

/** 
* �������ɸ�������9
*
* @param vfree9 ���ɸ�������9
*/
public void setVfree9 ( String vfree9) {
this.vfree9=vfree9;
 } 

/** 
* ��ȡ��Դ���ݺ�
*
* @return ��Դ���ݺ�
*/
public String getVsrccode () {
return this.vsrccode;
 } 

/** 
* ������Դ���ݺ�
*
* @param vsrccode ��Դ���ݺ�
*/
public void setVsrccode ( String vsrccode) {
this.vsrccode=vsrccode;
 } 

/** 
* ��ȡ��Դ�����к�
*
* @return ��Դ�����к�
*/
public String getVsrcrowno () {
return this.vsrcrowno;
 } 

/** 
* ������Դ�����к�
*
* @param vsrcrowno ��Դ�����к�
*/
public void setVsrcrowno ( String vsrcrowno) {
this.vsrcrowno=vsrcrowno;
 } 

/** 
* ��ȡ��Դ��������
*
* @return ��Դ��������
*/
public String getVsrctrantype () {
return this.vsrctrantype;
 } 

/** 
* ������Դ��������
*
* @param vsrctrantype ��Դ��������
*/
public void setVsrctrantype ( String vsrctrantype) {
this.vsrctrantype=vsrctrantype;
 } 

/** 
* ��ȡ��Դ��������
*
* @return ��Դ��������
*/
public String getVsrctype () {
return this.vsrctype;
 } 

/** 
* ������Դ��������
*
* @param vsrctype ��Դ��������
*/
public void setVsrctype ( String vsrctype) {
this.vsrctype=vsrctype;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("so.ShipmentsBVO");
  }
}