package nc.ui.so.qs.mmplanbill.process.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent;

public class PlanBillProcessHeadBeforeEdit implements IAppEventHandler<CardHeadTailBeforeEditEvent>{

	@Override
	public void handleAppEvent(CardHeadTailBeforeEditEvent event) {
		// TODO �Զ����ɵķ������
		
		if("vfree1".equals(event)){
			event.setReturnValue(false);
			return;
		}
		
		event.setReturnValue(true);
		
		
	}

}
