package nc.ui.so.fq01.billref.m30;

import java.awt.Container;

import nc.ui.pub.pf.BillSourceVar;
import nc.ui.pubapp.billref.src.view.SourceRefDlg;

public class M30RefFQ01SourceRefDlg extends SourceRefDlg{
	
	private static final long serialVersionUID = -7051627895911102475L;

	public M30RefFQ01SourceRefDlg(Container parent, BillSourceVar bsVar) {
		super(parent, bsVar);
		// TODO �Զ����ɵĹ��캯�����
	}

	public String getRefBillInfoBeanPath(){  
		
		return "nc/ui/so/m38/billref/m30/M30Ref38Info.xml";
		
	}  



}
