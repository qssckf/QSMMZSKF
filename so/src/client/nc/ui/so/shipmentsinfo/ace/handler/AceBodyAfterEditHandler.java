package nc.ui.so.shipmentsinfo.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.vo.so.qs.sc.ShipmentsBVO;
/**
 *���ݱ����ֶα༭���¼�
 * 
 * @since 6.0
 * @version 2011-7-12 ����08:17:33
 * @author duy
 */
public class AceBodyAfterEditHandler implements IAppEventHandler<CardBodyAfterEditEvent> {

    @Override
    public void handleAppEvent(CardBodyAfterEditEvent e) {
        String key = e.getKey();
        if (key.equals("cateralvid")) {
            nc.ui.so.shipmentsinfo.handler.MaterialHandler handler = new nc.ui.so.shipmentsinfo.handler.MaterialHandler();
            handler.afterEdit(e);
        }
    }

}
