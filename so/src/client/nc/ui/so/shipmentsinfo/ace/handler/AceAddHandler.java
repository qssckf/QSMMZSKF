package nc.ui.so.shipmentsinfo.ace.handler;

import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.vo.so.qs.sc.ShipmentsVO;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pub.lang.UFDate;
import nc.vo.pubapp.AppContext;

public class AceAddHandler implements IAppEventHandler<AddEvent> {

  @Override
  public void handleAppEvent(AddEvent e) {
    String pk_group = e.getContext().getPk_group();
    String pk_org = e.getContext().getPk_org();
    BillCardPanel panel = e.getBillForm().getBillCardPanel();
	    //��������֯Ĭ��ֵ
    panel.setHeadItem("pk_group", pk_group); 
    panel.setHeadItem("pk_org", pk_org); 

    //���õ���״̬������Ĭ��ֵ
    panel.setHeadItem("approvestatus", BillStatusEnum.FREE.value());
    panel.setHeadItem("dbilldate", AppContext.getInstance().getBusiDate()); 
    panel.setHeadItem("fstatusflag", BillStatusEnum.FREE.value());
    
    
    //���ò��ɱ༭�ֶ�
    panel.getHeadItem("pk_group").setEnabled(false);
    panel.getHeadItem("pk_org").setEnabled(false);
    panel.getHeadItem("pk_org_v").setEnabled(false);
    panel.getHeadItem("fstatusflag").setEnabled(false);
    panel.getHeadItem("iprintcount").setEnabled(false);
    
    panel.getHeadTailItem("creationtime").setEnabled(false);
    panel.getHeadTailItem("creator").setEnabled(false);			  
    panel.getHeadTailItem("modifier").setEnabled(false);
    panel.getHeadTailItem("modifiedtime").setEnabled(false);
    
    panel.getBodyItem("pk_group").setEnabled(false);
    panel.getBodyItem("pk_org").setEnabled(false);

    
  }

}
