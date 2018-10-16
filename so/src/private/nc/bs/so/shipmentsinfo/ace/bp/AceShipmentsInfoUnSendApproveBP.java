package nc.bs.so.shipmentsinfo.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼�����ջص�BP
 */
public class AceShipmentsInfoUnSendApproveBP {
  public AggShipmentsVO[] unSend(AggShipmentsVO[] clientBills,
      AggShipmentsVO[] originBills) {
    // ��VO�־û������ݿ���
    this.setHeadVOStatus(clientBills);
    BillUpdate<AggShipmentsVO> update = new BillUpdate<AggShipmentsVO>();
    AggShipmentsVO[] returnVos = update.update(clientBills, originBills);
    return returnVos;
  }
  
  private void setHeadVOStatus(AggShipmentsVO[] clientBills) {
        for (AggShipmentsVO clientBill : clientBills) {
        clientBill.getParentVO().setAttributeValue("approvestatus", BillStatusEnum.FREE.value());
            clientBill.getParentVO().setStatus(VOStatus.UPDATED);
        }
    }
}
