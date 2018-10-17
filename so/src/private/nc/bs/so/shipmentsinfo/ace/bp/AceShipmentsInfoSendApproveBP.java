package nc.bs.so.shipmentsinfo.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.so.qs.sc.AggShipmentsVO;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pub.VOStatus;

/**
 * ��׼���������BP
 */
public class AceShipmentsInfoSendApproveBP {
  /**
   * ������
   * 
   * @param vos ����VO����
   * @param script ���ݶ����ű�����
   * @return �����ĵ���VO����
   */
  
  public AggShipmentsVO[] sendApprove(AggShipmentsVO[] clientBills,
      AggShipmentsVO[] originBills) {
      for(AggShipmentsVO clientFullVO:clientBills){
		          clientFullVO.getParentVO().setAttributeValue("approvestatus", BillStatusEnum.COMMIT.value());
		          clientFullVO.getParentVO().setStatus(VOStatus.UPDATED);
	      }
    // ���ݳ־û�
    AggShipmentsVO[] returnVos =
        new BillUpdate<AggShipmentsVO>().update(clientBills, originBills);
    return returnVos;
  }
}
