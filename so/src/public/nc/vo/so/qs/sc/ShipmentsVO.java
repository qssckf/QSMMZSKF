package nc.vo.so.qs.sc;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class ShipmentsVO extends SuperVO {
/**
*����ʱ��
*/
public UFDateTime approvedate;
/**
*��������
*/
public String approvenote;
/**
*������
*/
public String approver;
/**
*����״̬
*/
public Integer approvestatus;
/**
*����ID
*/
public String billid;
/**
*�Ƶ���
*/
public String billmaker;
/**
*���ݺ�
*/
public String billno;
/**
*��������
*/
public String billtype;
/**
*���ݰ汾pk
*/
public String billversionpk;
/**
*ҵ������
*/
public String busitype;
/**
*������Դ����ID
*/
public String cbilsrcid;
/**
*�ͻ�
*/
public String ccustomerid;
/**
*���۲��Ű汾
*/
public String cdeptid;
/**
*���۲���
*/
public String cdeptvid;
/**
*ҵ��Ա
*/
public String cemployeeid;
/**
*����ʱ��
*/
public UFDateTime creationtime;
/**
*������
*/
public String creator;
/**
*��������
*/
public UFDate dbilldate;
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
*�޶�ö��
*/
public Integer emendenum;
/**
*�ն˿���
*/
public String finalcustomer;
/**
*����״̬
*/
public Integer fstatusflag;
/**
*��ӡ����
*/
public Integer iprintcount;
/**
*��ע
*/
public String memo;
/**
*�޸�ʱ��
*/
public UFDateTime modifiedtime;
/**
*�޸���
*/
public String modifier;
/**
*����
*/
public String pk_group;
/**
*������֯
*/
public String pk_org;
/**
*������֯�汾
*/
public String pk_org_v;
/**
*�������뵥����
*/
public String pk_shipments;
/**
*������֯
*/
public String pkorg;
/**
*�������ͱ�ʶ
*/
public String saletypeoid;
/**
*��Դ����id
*/
public String srcbillid;
/**
*��Դ��������
*/
public String srcbilltype;
/**
*��������
*/
public String transtype;
/**
*��������pk
*/
public String transtypepk;
/**
*ʱ���
*/
public UFDateTime ts;
/**
*���ݱ��
*/
public String vbillcode;
/**
*������Դ��������
*/
public String vbillsrctype;
/** 
* ��ȡ����ʱ��
*
* @return ����ʱ��
*/
public UFDateTime getApprovedate () {
return this.approvedate;
 } 

/** 
* ��������ʱ��
*
* @param approvedate ����ʱ��
*/
public void setApprovedate ( UFDateTime approvedate) {
this.approvedate=approvedate;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public String getApprovenote () {
return this.approvenote;
 } 

/** 
* ������������
*
* @param approvenote ��������
*/
public void setApprovenote ( String approvenote) {
this.approvenote=approvenote;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getApprover () {
return this.approver;
 } 

/** 
* ����������
*
* @param approver ������
*/
public void setApprover ( String approver) {
this.approver=approver;
 } 

/** 
* ��ȡ����״̬
*
* @return ����״̬
* @see String
*/
public Integer getApprovestatus () {
return this.approvestatus;
 } 

/** 
* ��������״̬
*
* @param approvestatus ����״̬
* @see String
*/
public void setApprovestatus ( Integer approvestatus) {
this.approvestatus=approvestatus;
 } 

/** 
* ��ȡ����ID
*
* @return ����ID
*/
public String getBillid () {
return this.billid;
 } 

/** 
* ���õ���ID
*
* @param billid ����ID
*/
public void setBillid ( String billid) {
this.billid=billid;
 } 

/** 
* ��ȡ�Ƶ���
*
* @return �Ƶ���
*/
public String getBillmaker () {
return this.billmaker;
 } 

/** 
* �����Ƶ���
*
* @param billmaker �Ƶ���
*/
public void setBillmaker ( String billmaker) {
this.billmaker=billmaker;
 } 

/** 
* ��ȡ���ݺ�
*
* @return ���ݺ�
*/
public String getBillno () {
return this.billno;
 } 

/** 
* ���õ��ݺ�
*
* @param billno ���ݺ�
*/
public void setBillno ( String billno) {
this.billno=billno;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public String getBilltype () {
return this.billtype;
 } 

/** 
* ���õ�������
*
* @param billtype ��������
*/
public void setBilltype ( String billtype) {
this.billtype=billtype;
 } 

/** 
* ��ȡ���ݰ汾pk
*
* @return ���ݰ汾pk
*/
public String getBillversionpk () {
return this.billversionpk;
 } 

/** 
* ���õ��ݰ汾pk
*
* @param billversionpk ���ݰ汾pk
*/
public void setBillversionpk ( String billversionpk) {
this.billversionpk=billversionpk;
 } 

/** 
* ��ȡҵ������
*
* @return ҵ������
*/
public String getBusitype () {
return this.busitype;
 } 

/** 
* ����ҵ������
*
* @param busitype ҵ������
*/
public void setBusitype ( String busitype) {
this.busitype=busitype;
 } 

/** 
* ��ȡ������Դ����ID
*
* @return ������Դ����ID
*/
public String getCbilsrcid () {
return this.cbilsrcid;
 } 

/** 
* ����������Դ����ID
*
* @param cbilsrcid ������Դ����ID
*/
public void setCbilsrcid ( String cbilsrcid) {
this.cbilsrcid=cbilsrcid;
 } 

/** 
* ��ȡ�ͻ�
*
* @return �ͻ�
*/
public String getCcustomerid () {
return this.ccustomerid;
 } 

/** 
* ���ÿͻ�
*
* @param ccustomerid �ͻ�
*/
public void setCcustomerid ( String ccustomerid) {
this.ccustomerid=ccustomerid;
 } 

/** 
* ��ȡ���۲��Ű汾
*
* @return ���۲��Ű汾
*/
public String getCdeptid () {
return this.cdeptid;
 } 

/** 
* �������۲��Ű汾
*
* @param cdeptid ���۲��Ű汾
*/
public void setCdeptid ( String cdeptid) {
this.cdeptid=cdeptid;
 } 

/** 
* ��ȡ���۲���
*
* @return ���۲���
*/
public String getCdeptvid () {
return this.cdeptvid;
 } 

/** 
* �������۲���
*
* @param cdeptvid ���۲���
*/
public void setCdeptvid ( String cdeptvid) {
this.cdeptvid=cdeptvid;
 } 

/** 
* ��ȡҵ��Ա
*
* @return ҵ��Ա
*/
public String getCemployeeid () {
return this.cemployeeid;
 } 

/** 
* ����ҵ��Ա
*
* @param cemployeeid ҵ��Ա
*/
public void setCemployeeid ( String cemployeeid) {
this.cemployeeid=cemployeeid;
 } 

/** 
* ��ȡ����ʱ��
*
* @return ����ʱ��
*/
public UFDateTime getCreationtime () {
return this.creationtime;
 } 

/** 
* ���ô���ʱ��
*
* @param creationtime ����ʱ��
*/
public void setCreationtime ( UFDateTime creationtime) {
this.creationtime=creationtime;
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getCreator () {
return this.creator;
 } 

/** 
* ���ô�����
*
* @param creator ������
*/
public void setCreator ( String creator) {
this.creator=creator;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public UFDate getDbilldate () {
return this.dbilldate;
 } 

/** 
* ���õ�������
*
* @param dbilldate ��������
*/
public void setDbilldate ( UFDate dbilldate) {
this.dbilldate=dbilldate;
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
* ��ȡ�޶�ö��
*
* @return �޶�ö��
*/
public Integer getEmendenum () {
return this.emendenum;
 } 

/** 
* �����޶�ö��
*
* @param emendenum �޶�ö��
*/
public void setEmendenum ( Integer emendenum) {
this.emendenum=emendenum;
 } 

/** 
* ��ȡ�ն˿���
*
* @return �ն˿���
*/
public String getFinalcustomer () {
return this.finalcustomer;
 } 

/** 
* �����ն˿���
*
* @param finalcustomer �ն˿���
*/
public void setFinalcustomer ( String finalcustomer) {
this.finalcustomer=finalcustomer;
 } 

/** 
* ��ȡ����״̬
*
* @return ����״̬
* @see String
*/
public Integer getFstatusflag () {
return this.fstatusflag;
 } 

/** 
* ���õ���״̬
*
* @param fstatusflag ����״̬
* @see String
*/
public void setFstatusflag ( Integer fstatusflag) {
this.fstatusflag=fstatusflag;
 } 

/** 
* ��ȡ��ӡ����
*
* @return ��ӡ����
*/
public Integer getIprintcount () {
return this.iprintcount;
 } 

/** 
* ���ô�ӡ����
*
* @param iprintcount ��ӡ����
*/
public void setIprintcount ( Integer iprintcount) {
this.iprintcount=iprintcount;
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
* ��ȡ�޸�ʱ��
*
* @return �޸�ʱ��
*/
public UFDateTime getModifiedtime () {
return this.modifiedtime;
 } 

/** 
* �����޸�ʱ��
*
* @param modifiedtime �޸�ʱ��
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.modifiedtime=modifiedtime;
 } 

/** 
* ��ȡ�޸���
*
* @return �޸���
*/
public String getModifier () {
return this.modifier;
 } 

/** 
* �����޸���
*
* @param modifier �޸���
*/
public void setModifier ( String modifier) {
this.modifier=modifier;
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
* ��ȡ������֯�汾
*
* @return ������֯�汾
*/
public String getPk_org_v () {
return this.pk_org_v;
 } 

/** 
* ����������֯�汾
*
* @param pk_org_v ������֯�汾
*/
public void setPk_org_v ( String pk_org_v) {
this.pk_org_v=pk_org_v;
 } 

/** 
* ��ȡ�������뵥����
*
* @return �������뵥����
*/
public String getPk_shipments () {
return this.pk_shipments;
 } 

/** 
* ���÷������뵥����
*
* @param pk_shipments �������뵥����
*/
public void setPk_shipments ( String pk_shipments) {
this.pk_shipments=pk_shipments;
 } 

/** 
* ��ȡ������֯
*
* @return ������֯
*/
public String getPkorg () {
return this.pkorg;
 } 

/** 
* ����������֯
*
* @param pkorg ������֯
*/
public void setPkorg ( String pkorg) {
this.pkorg=pkorg;
 } 

/** 
* ��ȡ�������ͱ�ʶ
*
* @return �������ͱ�ʶ
*/
public String getSaletypeoid () {
return this.saletypeoid;
 } 

/** 
* �����������ͱ�ʶ
*
* @param saletypeoid �������ͱ�ʶ
*/
public void setSaletypeoid ( String saletypeoid) {
this.saletypeoid=saletypeoid;
 } 

/** 
* ��ȡ��Դ����id
*
* @return ��Դ����id
*/
public String getSrcbillid () {
return this.srcbillid;
 } 

/** 
* ������Դ����id
*
* @param srcbillid ��Դ����id
*/
public void setSrcbillid ( String srcbillid) {
this.srcbillid=srcbillid;
 } 

/** 
* ��ȡ��Դ��������
*
* @return ��Դ��������
*/
public String getSrcbilltype () {
return this.srcbilltype;
 } 

/** 
* ������Դ��������
*
* @param srcbilltype ��Դ��������
*/
public void setSrcbilltype ( String srcbilltype) {
this.srcbilltype=srcbilltype;
 } 

/** 
* ��ȡ��������
*
* @return ��������
*/
public String getTranstype () {
return this.transtype;
 } 

/** 
* ���ý�������
*
* @param transtype ��������
*/
public void setTranstype ( String transtype) {
this.transtype=transtype;
 } 

/** 
* ��ȡ��������pk
*
* @return ��������pk
*/
public String getTranstypepk () {
return this.transtypepk;
 } 

/** 
* ���ý�������pk
*
* @param transtypepk ��������pk
*/
public void setTranstypepk ( String transtypepk) {
this.transtypepk=transtypepk;
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
* ��ȡ���ݱ��
*
* @return ���ݱ��
*/
public String getVbillcode () {
return this.vbillcode;
 } 

/** 
* ���õ��ݱ��
*
* @param vbillcode ���ݱ��
*/
public void setVbillcode ( String vbillcode) {
this.vbillcode=vbillcode;
 } 

/** 
* ��ȡ������Դ��������
*
* @return ������Դ��������
*/
public String getVbillsrctype () {
return this.vbillsrctype;
 } 

/** 
* ����������Դ��������
*
* @param vbillsrctype ������Դ��������
*/
public void setVbillsrctype ( String vbillsrctype) {
this.vbillsrctype=vbillsrctype;
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("so.ShipmentsVO");
  }
}