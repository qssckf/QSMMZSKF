package nc.ui.so.qs.mmplanbill.process.view;

import nc.ui.pub.bill.BillItem;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;

public class PlanBillProcessBillFrom extends ShowUpableBillForm{
	
	private String[] headFields={"plandate"};
	
	

	@Override
	public void initUI() {
		// TODO �Զ����ɵķ������
		
		super.initUI();
		
		this.setComponentVisible(true);
	}



	@Override
	protected void onEdit() {
		// TODO �Զ����ɵķ������
		super.onEdit();
		
		BillItem[] heads=this.getBillCardPanel().getHeadItems();
		
		for(BillItem item:heads){
			item.setEnabled(false);
		}
		
		for(String field:headFields){
			if(this.billCardPanel.getHeadTailItem(field)!=null){
				this.billCardPanel.getHeadTailItem(field).setEnabled(true);
			}
		}
		
		
		
	}
	
	
	
	
	

}
