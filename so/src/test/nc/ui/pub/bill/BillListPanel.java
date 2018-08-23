/*      */ package nc.ui.pub.bill;
/*      */ 
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ComponentAdapter;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.util.HashMap;
/*      */ import javax.swing.ActionMap;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.InputMap;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import nc.bs.logging.Logger;
/*      */ import nc.ui.ml.NCLangRes;
/*      */ import nc.ui.pub.beans.UIMenuItem;
/*      */ import nc.ui.pub.beans.UIPanel;
/*      */ import nc.ui.pub.beans.UIPopupMenu;
/*      */ import nc.ui.pub.beans.UISplitPane;
/*      */ import nc.ui.pub.beans.UITable;
/*      */ import nc.ui.pub.bill.action.BillListUISetAction;
/*      */ import nc.uitheme.ui.ThemeResourceCenter;
/*      */ import nc.vo.pub.AggregatedValueObject;
/*      */ import nc.vo.pub.CircularlyAccessibleValueObject;
/*      */ import nc.vo.pub.bill.BillTabVO;
/*      */ import nc.vo.pub.bill.BillTempletVO;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BillListPanel
/*      */   extends UIPanel
/*      */   implements IBillItem
/*      */ {
/*      */   public static final String PREBILLLIST = "TBL_";
/*   41 */   private UISplitPane split = null;
/*      */   
/*   43 */   private UIPanel m_HeadPanel = null;
/*      */   
/*   45 */   private BillScrollPane m_ParentPanel = null;
/*      */   
/*      */ 
/*   48 */   private BillTabbedPane m_bodyTabbedPane = null;
/*      */   
/*   50 */   private UIPanel m_bodyPanel = null;
/*      */   
/*      */ 
/*   53 */   private BillListData m_ListData = null;
/*      */   
/*      */ 
/*   56 */   protected String m_strBillType = null;
/*      */   
/*      */ 
/*   59 */   protected String m_strBusiType = null;
/*      */   
/*      */ 
/*   62 */   protected String m_strCorp = null;
/*      */   
/*      */ 
/*   65 */   protected String m_strOperator = null;
/*      */   
/*      */ 
/*   68 */   protected String nodeKey = null;
/*      */   
/*      */ 
/*   71 */   protected boolean m_bMultiSelect = false;
/*      */   
/*      */ 
/*   74 */   private BillTableMouseListener ml = null;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*   86 */   protected UIPopupMenu pmHeadLock = null;
/*      */   
/*   88 */   protected UIPopupMenu pmBodyLock = null;
/*      */   
/*   90 */   protected UIMenuItem miLock = new UIMenuItem(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000009"));
/*      */   
/*      */ 
/*   93 */   protected UIMenuItem miLock2 = new UIMenuItem(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000009"));
/*      */   
/*      */ 
/*      */ 
/*   97 */   private boolean bHeadLock = false;
/*      */   
/*   99 */   private boolean bBodyLock = false;
/*      */   
/*  101 */   private int m_iHeadLockCol = -1;
/*      */   
/*  103 */   private HashMap<String, Integer> hBodyLockCols = new HashMap();
/*      */   
/*      */   public class HeadMouseListener implements BillTableMouseListener
/*      */   {
/*      */     public HeadMouseListener() {}
/*      */     
/*      */     public void mouse_doubleclick(BillMouseEnent e)
/*      */     {
/*  111 */       if (BillListPanel.this.ml != null) {
/*  112 */         BillMouseEnent ev = new BillMouseEnent(e.getSource(), e.getRow(), 0);
/*      */         
/*  114 */         BillListPanel.this.ml.mouse_doubleclick(ev);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public class BodyMouseListener implements BillTableMouseListener
/*      */   {
/*      */     public BodyMouseListener() {}
/*      */     
/*      */     public void mouse_doubleclick(BillMouseEnent e)
/*      */     {
/*  125 */       if (BillListPanel.this.ml != null) {
/*  126 */         BillMouseEnent ev = new BillMouseEnent(e.getSource(), e.getRow(), 1);
/*      */         
/*  128 */         BillListPanel.this.ml.mouse_doubleclick(ev);
/*      */       }
/*  130 */       BillListPanel.this.updateUI();
/*      */     }
/*      */   }
/*      */   
/*      */   private class HeadRowStateListener implements IBillModelRowStateChangeEventListener
/*      */   {
/*      */     private HeadRowStateListener() {}
/*      */     
/*      */     public void valueChanged(RowStateChangeEvent e) {
/*  139 */       BillModel model = BillListPanel.this.getBodyBillModel();
/*  140 */       IBillModelRowStateChangeEventListener l = model.getRowStateChangeEventListener();
/*      */       
/*  142 */       model.removeRowStateChangeEventListener();
/*      */       
/*  144 */       if (e.isSelectState()) {
/*  145 */         BillListPanel.this.getChildListPanel().selectAllTableRow();
/*      */       } else {
/*  147 */         BillListPanel.this.getChildListPanel().cancelSelectAllTableRow();
/*      */       }
/*  149 */       model.addRowStateChangeEventListener(l);
/*      */       
/*  151 */       BillListPanel.this.updateUI();
/*      */     }
/*      */   }
/*      */   
/*      */   private class BodyRowStateListener implements IBillModelRowStateChangeEventListener
/*      */   {
/*      */     private BodyRowStateListener() {}
/*      */     
/*      */     public void valueChanged(RowStateChangeEvent e)
/*      */     {
/*  161 */       BillModel model = BillListPanel.this.getHeadBillModel();
/*  162 */       IBillModelRowStateChangeEventListener l = model.getRowStateChangeEventListener();
/*      */       
/*  164 */       model.removeRowStateChangeEventListener();
/*      */       
/*  166 */       int row = BillListPanel.this.getHeadTable().getSelectedRow();
/*      */       
/*  168 */       if (row == -1) {
/*  169 */         return;
/*      */       }
/*      */       
/*  172 */       int state = 4;
/*  173 */       RowAttribute ra = model.getRowAttribute(row);
/*  174 */       int oldstats = ra.getRowState();
/*  175 */       boolean isFireHeadRowEvent = false;
/*  176 */       if (e.isSelectState())
/*      */       {
/*  178 */         model.setRowState(row, 4);
/*  179 */         state = 4;
/*  180 */         isFireHeadRowEvent = true;
/*      */       }
/*  182 */       else if (!BillListPanel.this.getBodyBillModel().isHasSelectRow()) {
/*  183 */         model.setRowState(row, -1);
/*  184 */         state = -1;
/*  185 */         isFireHeadRowEvent = true;
/*      */       }
/*      */       
/*      */ 
/*  189 */       if ((model.getHeadRowStateChangeEventListener() != null) && (isFireHeadRowEvent))
/*      */       {
/*  191 */         RowStateChangeEvent event = new RowStateChangeEvent(this, row, oldstats, state);
/*      */         
/*  193 */         model.getHeadRowStateChangeEventListener().valueChanged(event);
/*      */       }
/*      */       
/*  196 */       model.addRowStateChangeEventListener(l);
/*      */       
/*  198 */       BillListPanel.this.updateUI();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillListPanel()
/*      */   {
/*  208 */     initialize();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillListPanel(boolean bWithSort)
/*      */   {
/*  217 */     initialize();
/*      */   }
/*      */   
/*      */   public void addBodyEditListener(BillEditListener l)
/*      */   {
/*  222 */     if (this.m_ListData == null) {
/*  223 */       return;
/*      */     }
/*  225 */     String[] codes = this.m_ListData.getBodyTableCodes();
/*  226 */     if ((codes == null) || (codes.length == 0))
/*  227 */       return;
/*  228 */     for (int i = 0; i < codes.length; i++) {
/*  229 */       if (getBodyScrollPane(codes[i]) != null) {
/*  230 */         getBodyScrollPane(codes[i]).addEditListener(l);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addBodyPanel(BillTabVO[] btvos)
/*      */   {
/*  240 */     if (btvos != null) {
/*  241 */       BillScrollPane[] sps = new BillScrollPane[btvos.length];
/*  242 */       for (int i = 0; i < btvos.length; i++) {
/*  243 */         String tablecode = btvos[i].getTabcode();
/*  244 */         String tablename = btvos[i].getTabname();
/*  245 */         sps[i] = createDefaultBodyScrollPane();
/*  246 */         sps[i].setTableCode(tablecode);
/*  247 */         sps[i].setTableName(tablename);
/*      */       }
/*  249 */       getBodyTabbedPane().addScrollPane(btvos, sps);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addBodyPanel(String tablecode, String tablename, boolean showTab)
/*      */   {
/*  259 */     BillTabVO btvo = new BillTabVO();
/*  260 */     btvo.setPos(Integer.valueOf(1));
/*  261 */     btvo.setTabcode(tablecode);
/*  262 */     btvo.setTabname(tablename);
/*  263 */     addBodyPanel(new BillTabVO[] { btvo });
/*      */   }
/*      */   
/*      */   public void addEditListener(BillEditListener l) {
/*  267 */     getParentListPanel().addEditListener(l);
/*      */   }
/*      */   
/*      */   public void addHeadEditListener(BillEditListener l) {
/*  271 */     getParentListPanel().addEditListener(l);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addMouseListener(BillTableMouseListener ml)
/*      */   {
/*  281 */     this.ml = ml;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void adjustSplitPanel()
/*      */   {
/*  288 */     if ((getParentListPanel().isVisible()) && (!hasHeadItems())) {
/*  289 */       getParentListPanel().setVisible(false);
/*      */     }
/*      */     
/*  292 */     if ((getBodyUIPanel().isVisible()) && (!hasBodyTableCodes())) {
/*  293 */       getBodyUIPanel().setVisible(false);
/*      */     }
/*      */     
/*  296 */     setSplitPanelDividerSize();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void clearCopyData()
/*      */   {
/*  303 */     getBillListData().clearCopyData();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillScrollPane createDefaultBodyScrollPane()
/*      */   {
/*  345 */     BillScrollPane m_ChildPanel = null;
/*      */     try {
/*  347 */       m_ChildPanel = BillScrollPane.createDefaultBillScrollPane();
/*  348 */       m_ChildPanel.setBillParent(this);
/*  349 */       m_ChildPanel.setName("ChildPanel");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  358 */       m_ChildPanel.addMouseListener(new BodyMouseListener());
/*      */       
/*  360 */       m_ChildPanel.setPreferredSize(new Dimension(10, 200));
/*      */ 
/*      */     }
/*      */     catch (Throwable ivjExc)
/*      */     {
/*  365 */       handleException(ivjExc);
/*      */     }
/*  367 */     return m_ChildPanel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillListData getBillListData()
/*      */   {
/*  376 */     if (this.m_ListData == null)
/*  377 */       this.m_ListData = new BillListData();
/*  378 */     return this.m_ListData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBillType()
/*      */   {
/*  387 */     return this.m_strBillType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public AggregatedValueObject getBillValueVO(int row, String billVOName, String headVOName, String bodyVOName)
/*      */   {
/*  395 */     return getBillListData().getBillValueVO(row, billVOName, headVOName, bodyVOName);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillModel getBodyBillModel()
/*      */   {
/*  405 */     return this.m_ListData.getBodyBillModel(getChildListPanel().getTableCode());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillModel getBodyBillModel(String tableCode)
/*      */   {
/*  414 */     return this.m_ListData.getBodyBillModel(tableCode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillItem getBodyItem(String strKey)
/*      */   {
/*  423 */     return getBillListData().getBodyItem(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillItem getBodyItem(String tableCode, String strKey)
/*      */   {
/*  432 */     return getBillListData().getBodyItem(tableCode, strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected UIPopupMenu getBodyLockMenu()
/*      */   {
/*  440 */     BillScrollPane bsp = getChildListPanel();
/*  441 */     if (bsp != null)
/*  442 */       return getBodyLockMenu(bsp.getTableCode());
/*  443 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected UIPopupMenu getBodyLockMenu(String tableCode)
/*      */   {
/*  452 */     BillScrollPane bsp = getChildListPanel(tableCode);
/*      */     
/*  454 */     if (bsp != null)
/*      */     {
/*  456 */       return bsp.getPmBodyHead();
/*      */     }
/*  458 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillScrollPane getBodyScrollPane(String tableCode)
/*      */   {
/*  470 */     if (tableCode == null) {
/*  471 */       return null;
/*      */     }
/*  473 */     BillTabbedPane btp = getBodyTabbedPane();
/*  474 */     if (btp.getTabCount() == 0)
/*      */     {
/*  476 */       addBodyPanel(tableCode, this.m_ListData.getBodyTableName(tableCode), false);
/*      */     }
/*      */     
/*      */ 
/*  480 */     BillTabVO btvo = new BillTabVO();
/*  481 */     btvo.setPos(Integer.valueOf(1));
/*  482 */     btvo.setTabcode(tableCode);
/*  483 */     return (BillScrollPane)btp.getScrollPane(btvo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTabbedPane getBodyTabbedPane()
/*      */   {
/*  493 */     if (this.m_bodyTabbedPane == null) {
/*  494 */       this.m_bodyTabbedPane = new BillTabbedPane();
/*  495 */       this.m_bodyTabbedPane.setName("BodyTabbedPane");
/*      */       
/*  497 */       this.m_bodyTabbedPane.addChangeListener(new ChangeListener()
/*      */       {
/*      */ 
/*  500 */         int index = -1;
/*      */         
/*      */         public void stateChanged(ChangeEvent e) {
/*  503 */           BillTabbedPane.onBillTabbedChange(BillListPanel.this.m_bodyTabbedPane, this.index);
/*      */           
/*  505 */           this.index = BillListPanel.this.m_bodyTabbedPane.getSelectedIndex();
/*      */         }
/*      */       });
/*      */     }
/*  509 */     return this.m_bodyTabbedPane;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public UITable getBodyTable()
/*      */   {
/*  519 */     BillScrollPane bsp = getChildListPanel();
/*  520 */     if (bsp != null) {
/*  521 */       return bsp.getTable();
/*      */     }
/*  523 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public UITable getBodyTable(String tableCode)
/*      */   {
/*  534 */     BillScrollPane bsp = getBodyScrollPane(tableCode);
/*      */     
/*  536 */     return bsp == null ? null : bsp.getTable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String[] getBodyTableCodes()
/*      */   {
/*  545 */     String[] tableCodes = null;
/*  546 */     if (getBillListData() != null)
/*  547 */       tableCodes = getBillListData().getBodyTableCodes();
/*  548 */     return tableCodes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public UIPanel getBodyUIPanel()
/*      */   {
/*  558 */     if (this.m_bodyPanel == null) {
/*      */       try {
/*  560 */         this.m_bodyPanel = new UIPanel();
/*  561 */         this.m_bodyPanel.setLayout(new BorderLayout());
/*  562 */         this.m_bodyPanel.setName("BodyUIPanel");
/*  563 */         getBodyUIPanel().add(getBodyTabbedPane(), "Center");
/*  564 */         getBodyUIPanel().addComponentListener(new ComponentAdapter()
/*      */         {
/*      */ 
/*      */           public void componentHidden(ComponentEvent e)
/*      */           {
/*      */ 
/*  570 */             super.componentHidden(e);
/*  571 */             BillListPanel.this.setSplitPanelDividerSize();
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */           public void componentShown(ComponentEvent e)
/*      */           {
/*  579 */             super.componentShown(e);
/*  580 */             BillListPanel.this.setSplitPanelDividerSize();
/*      */           }
/*      */           
/*      */ 
/*      */         });
/*      */ 
/*      */       }
/*      */       catch (Throwable ivjExc)
/*      */       {
/*  589 */         handleException(ivjExc);
/*      */       }
/*      */     }
/*  592 */     return this.m_bodyPanel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBusiType()
/*      */   {
/*  601 */     return this.m_strBusiType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillScrollPane getChildListPanel()
/*      */   {
/*  611 */     BillTabbedPane btp = getBodyTabbedPane();
/*  612 */     if (btp.getTabCount() == 0) {
/*  613 */       addBodyPanel(BillListData.DEFAULT_TABLECODE, BillListData.DEFAULT_TABLENAME, false);
/*      */     }
/*      */     
/*  616 */     if (btp.getTabCount() == 0)
/*  617 */       return null;
/*  618 */     return (BillScrollPane)btp.getSelectedScrollPane();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillScrollPane getChildListPanel(String tableCode)
/*      */   {
/*  628 */     return getBodyScrollPane(tableCode);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getCorp()
/*      */   {
/*  637 */     return this.m_strCorp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   String getDefaultTableCode()
/*      */   {
/*  646 */     String tablecode = BillListData.DEFAULT_TABLECODE;
/*  647 */     if ((getBodyTableCodes() != null) && (getBodyTableCodes().length >= 1)) {
/*  648 */       tablecode = getBodyTableCodes()[0];
/*      */     }
/*  650 */     return tablecode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTempletVO getDefaultTemplet(String strBillType, String strBusiType, String strOperator, String strCorp)
/*      */   {
/*  662 */     return getDefaultTemplet(strBillType, strBusiType, strOperator, strCorp, getNodeKey());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTempletVO getDefaultTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, String nodeKey)
/*      */   {
/*  670 */     return getDefaultTemplet(strBillType, strBusiType, strOperator, strCorp, nodeKey, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTempletVO getDefaultTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, String nodeKey, String orgtype)
/*      */   {
/*  683 */     return BillUIUtil.getDefaultTempletStatic(strBillType, strBusiType, strOperator, strCorp, nodeKey, orgtype);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillModel getHeadBillModel()
/*      */   {
/*  693 */     return this.m_ListData.getHeadBillModel();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillItem getHeadItem(String strKey)
/*      */   {
/*  702 */     return getBillListData().getHeadItem(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected UIPopupMenu getHeadLockMenu()
/*      */   {
/*  710 */     BillScrollPane bsp = getParentListPanel();
/*      */     
/*  712 */     if (bsp != null)
/*      */     {
/*  714 */       return bsp.getPmBodyHead();
/*      */     }
/*  716 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public UITable getHeadTable()
/*      */   {
/*  726 */     return getParentListPanel().getTable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public AggregatedValueObject[] getMultiSelectedVOs(String billVOName, String headVOName, String bodyVOName)
/*      */   {
/*  734 */     int row = getHeadTable().getSelectedRow();
/*  735 */     if (row > -1)
/*      */     {
/*  737 */       setBodyModelDataCopy(row);
/*      */     }
/*  739 */     return getBillListData().getBillSelectValueVOs(billVOName, headVOName, bodyVOName);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getNodeKey()
/*      */   {
/*  749 */     return this.nodeKey;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  758 */     return this.m_strOperator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillScrollPane getParentListPanel()
/*      */   {
/*  768 */     if (this.m_ParentPanel == null) {
/*      */       try {
/*  770 */         this.m_ParentPanel = BillScrollPane.createDefaultBillScrollPane();
/*  771 */         this.m_ParentPanel.setBillParent(this);
/*  772 */         this.m_ParentPanel.setName("ParentPanel");
/*  773 */         this.m_ParentPanel.addMouseListener(new HeadMouseListener());
/*      */         
/*  775 */         this.m_ParentPanel.addComponentListener(new ComponentAdapter()
/*      */         {
/*      */ 
/*      */           public void componentHidden(ComponentEvent e)
/*      */           {
/*      */ 
/*  781 */             super.componentHidden(e);
/*  782 */             BillListPanel.this.setSplitPanelDividerSize();
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */           public void componentShown(ComponentEvent e)
/*      */           {
/*  790 */             super.componentShown(e);
/*  791 */             BillListPanel.this.setSplitPanelDividerSize();
/*      */           }
/*      */           
/*      */ 
/*      */         });
/*      */       }
/*      */       catch (Throwable ivjExc)
/*      */       {
/*  799 */         handleException(ivjExc);
/*      */       }
/*      */     }
/*  802 */     return this.m_ParentPanel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public AggregatedValueObject getSelectedVO(String billVOName, String headVOName, String bodyVOName)
/*      */   {
/*  810 */     return getBillListData().getBillSelectValueVO(billVOName, headVOName, bodyVOName);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTempletVO getTempletData(String strID)
/*      */   {
/*  821 */     return BillUIUtil.getDefaultTempletStatic(strID, getCorp());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BillTempletVO getTempletDataForced(String strID)
/*      */   {
/*  831 */     BillTempletVO resultVO = null;
/*      */     try {
/*  833 */       resultVO = BillTemplateHelper.findListTempletData(strID, getCorp());
/*      */     } catch (Exception e) {
/*  835 */       Logger.error(e.getMessage());
/*      */     }
/*      */     
/*  838 */     return resultVO;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public UISplitPane getUISplitPane()
/*      */   {
/*  849 */     if (this.split == null) {
/*      */       try {
/*  851 */         this.split = new UISplitPane(0);
/*      */         
/*  853 */         this.split.setName("UISplitPane");
/*  854 */         this.split.setDividerLocation(2);
/*      */         
/*  856 */         getUISplitPane().add(getHeadPanel(), "top");
/*      */         
/*  858 */         getUISplitPane().add(getBodyUIPanel(), "bottom");
/*  859 */         this.split.setBorder(null);
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  865 */         getUISplitPane().addComponentListener(new ComponentAdapter()
/*      */         {
/*      */ 
/*      */           public void componentResized(ComponentEvent e)
/*      */           {
/*  870 */             super.componentResized(e);
/*  871 */             BillListPanel.this.setSplitPanelDividerSize();
/*      */           }
/*      */           
/*      */ 
/*      */         });
/*      */       }
/*      */       catch (Throwable ivjExc)
/*      */       {
/*  879 */         handleException(ivjExc);
/*      */       }
/*      */     }
/*  882 */     return this.split;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void handleException(Throwable exception)
/*      */   {
/*  894 */     Logger.error(exception.getMessage());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean hasBodyTableCodes()
/*      */   {
/*  903 */     if (this.m_ListData == null)
/*  904 */       return false;
/*  905 */     String[] codes = this.m_ListData.getBodyTableCodes();
/*  906 */     if ((codes == null) || (codes.length == 0)) {
/*  907 */       return false;
/*      */     }
/*  909 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean hasHeadItems()
/*      */   {
/*  919 */     BillModel model = null;
/*  920 */     BillItem[] items = null;
/*      */     
/*  922 */     if ((this.m_ListData == null) || ((model = this.m_ListData.getHeadBillModel()) == null) || ((items = model.getBodyItems()) == null) || (items.length == 0))
/*      */     {
/*      */ 
/*  925 */       return false;
/*      */     }
/*      */     
/*  928 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void hideBodyTableCol(String strKey)
/*      */   {
/*  939 */     hideBodyTableCol(getDefaultTableCode(), strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void hideBodyTableCol(String tableCode, String strKey)
/*      */   {
/*  949 */     getBodyScrollPane(tableCode).hideTableCol(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void hideHeadTableCol(String strKey)
/*      */   {
/*  959 */     getParentListPanel().hideTableCol(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void init()
/*      */   {
/*  967 */     if ((getBillType() != null) && (getOperator() != null) && (getCorp() != null)) {
/*  968 */       loadTemplet();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void initChildListPanel()
/*      */   {
/*  976 */     if (!hasBodyTableCodes()) {
/*  977 */       return;
/*      */     }
/*  979 */     getBodyTabbedPane().removeAll();
/*  980 */     BillTabVO[] btvos = this.m_ListData.getBodyBillTabVOs();
/*  981 */     if (btvos != null) {
/*  982 */       addBodyPanel(btvos);
/*  983 */       for (int i = 0; i < btvos.length; i++) {
/*  984 */         initChildListPanel(btvos[i].getTabcode());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void initChildListPanel(String tableCode)
/*      */   {
/*  993 */     if (this.m_ListData == null)
/*  994 */       return;
/*  995 */     BillScrollPane bsp = getBodyScrollPane(tableCode);
/*  996 */     bsp.setTableModel(this.m_ListData.getBodyBillModel(tableCode));
/*  997 */     bsp.setRowNOShow(true);
/*      */     
/*  999 */     JTable table = getBodyScrollPane(tableCode).getTable();
/*      */     
/*      */ 
/* 1002 */     table.setSelectionMode(0);
/* 1003 */     if (table.getColumnCount() == 0) {
/* 1004 */       getBodyTabbedPane().removeScrollPane(bsp);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void initialize()
/*      */   {
/*      */     try
/*      */     {
/* 1016 */       setName("BillListPanel");
/* 1017 */       setLayout(new BorderLayout());
/* 1018 */       setSize(579, 370);
/* 1019 */       add(getUISplitPane(), "Center");
/* 1020 */       Color splitColor = ThemeResourceCenter.getInstance().getColor("themeres/ui/toolbaricons/uif2Control.theme.xml", "splitColor");
/* 1021 */       setBorder(BorderFactory.createLineBorder(splitColor));
/* 1022 */       registerBillKey();
/*      */     }
/*      */     catch (Throwable ivjExc) {
/* 1025 */       handleException(ivjExc);
/*      */     }
/*      */     
/* 1028 */     init();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void initParentListPanel()
/*      */   {
/* 1037 */     if (!hasHeadItems()) {
/* 1038 */       return;
/*      */     }
/* 1040 */     getParentListPanel().setTableModel(this.m_ListData.getHeadBillModel());
/* 1041 */     getParentListPanel().setRowNOShow(true);
/*      */     
/*      */ 
/* 1044 */     getParentListPanel().getTable().setSelectionMode(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isMultiSelect()
/*      */   {
/* 1055 */     return this.m_bMultiSelect;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void loadDefaultTemplet(BillTempletVO newTempletVO)
/*      */   {
/* 1073 */     setListData(new BillListData(newTempletVO));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void loadDefaultTemplet(BillTempletVO newTempletVO, IBillListData ibld)
/*      */   {
/* 1084 */     setListData(new BillListData(newTempletVO), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet()
/*      */   {
/* 1094 */     loadDefaultTemplet(getDefaultTemplet(getBillType(), getBusiType(), getOperator(), getCorp()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strID)
/*      */   {
/* 1105 */     setListData(new BillListData(getTempletData(strID)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strBillType, String strBusiType, String strOperator, String strCorp)
/*      */   {
/* 1116 */     loadTemplet(strBillType, strBusiType, strOperator, strCorp, getNodeKey());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, String nodeKey)
/*      */   {
/* 1128 */     this.m_strBillType = strBillType;
/* 1129 */     this.m_strOperator = strOperator;
/* 1130 */     this.m_strCorp = strCorp;
/* 1131 */     loadDefaultTemplet(getDefaultTemplet(getBillType(), getBusiType(), getOperator(), getCorp(), nodeKey));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, String nodeKey, IBillListData ibld)
/*      */   {
/* 1144 */     loadTemplet(strBillType, strBusiType, strOperator, strCorp, nodeKey, null, ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, String nodeKey, String orgtype, IBillListData ibld)
/*      */   {
/* 1157 */     this.m_strBillType = strBillType;
/* 1158 */     this.m_strOperator = strOperator;
/* 1159 */     this.m_strCorp = strCorp;
/* 1160 */     loadDefaultTemplet(getDefaultTemplet(getBillType(), getBusiType(), getOperator(), getCorp(), nodeKey, orgtype), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strBillType, String strBusiType, String strOperator, String strCorp, IBillListData ibld)
/*      */   {
/* 1172 */     loadTemplet(strBillType, strBusiType, strOperator, strCorp, getNodeKey(), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(String strID, IBillListData ibld)
/*      */   {
/* 1183 */     setListData(new BillListData(getTempletData(strID)), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTemplet(IBillListData ibld)
/*      */   {
/* 1193 */     loadDefaultTemplet(getDefaultTemplet(getBillType(), getBusiType(), getOperator(), getCorp()), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTempletForced(String strID)
/*      */   {
/* 1204 */     setListData(new BillListData(getTempletDataForced(strID)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void loadTempletForced(String strID, IBillListData ibld)
/*      */   {
/* 1214 */     setListData(new BillListData(getTempletDataForced(strID)), ibld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void lockBodyTableCol(String tablecode)
/*      */   {
/* 1221 */     int col = 0;
/* 1222 */     if ((this.hBodyLockCols != null) && (this.hBodyLockCols.containsKey(tablecode))) {
/* 1223 */       col = ((Integer)this.hBodyLockCols.get(tablecode)).intValue();
/*      */     }
/* 1225 */     getChildListPanel().lockTableCol(col);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void onBodyLockMenuClicked(ActionEvent e)
/*      */   {
/* 1232 */     UIMenuItem item = (UIMenuItem)e.getSource();
/* 1233 */     if (item == this.miLock2) {
/* 1234 */       if (this.bBodyLock) {
/* 1235 */         getChildListPanel().unlockTableCol();
/* 1236 */         item.setText(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000009"));
/*      */       }
/*      */       else {
/* 1239 */         String tablecode = getDefaultTableCode();
/* 1240 */         int col = 0;
/* 1241 */         if ((this.hBodyLockCols != null) && (this.hBodyLockCols.containsKey(tablecode)))
/*      */         {
/* 1243 */           col = ((Integer)this.hBodyLockCols.get(tablecode)).intValue(); }
/* 1244 */         getChildListPanel().lockTableCol(col);
/* 1245 */         item.setText(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000010"));
/*      */       }
/*      */       
/* 1248 */       this.bBodyLock = (!this.bBodyLock);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void onHeadLockMenuClicked(ActionEvent e)
/*      */   {
/* 1256 */     UIMenuItem item = (UIMenuItem)e.getSource();
/* 1257 */     if (item == this.miLock) {
/* 1258 */       if (this.bHeadLock) {
/* 1259 */         getParentListPanel().unlockTableCol();
/* 1260 */         item.setText(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000009"));
/*      */       }
/*      */       else {
/* 1263 */         getParentListPanel().lockTableCol(this.m_iHeadLockCol);
/* 1264 */         item.setText(NCLangRes.getInstance().getStrByID("_Bill", "UPP_Bill-000010"));
/*      */       }
/*      */       
/* 1267 */       this.bHeadLock = (!this.bHeadLock);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBillType(String strBillType)
/*      */   {
/* 1275 */     this.m_strBillType = strBillType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean setBodyModelData(int row)
/*      */   {
/* 1282 */     return setBodyModelData(getDefaultTableCode(), row);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean setBodyModelData(String tableCode, int row)
/*      */   {
/* 1289 */     return getBillListData().setBodyModelData(tableCode, row);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBodyModelDataCopy(int row)
/*      */   {
/* 1296 */     setBodyModelDataCopy(getDefaultTableCode(), row);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBodyModelDataCopy(String tableCode, int row)
/*      */   {
/* 1303 */     getBillListData().setBodyModelDataCopy(tableCode, row);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBodyValueVO(CircularlyAccessibleValueObject[] bodyVOs)
/*      */   {
/* 1311 */     setBodyValueVO(getDefaultTableCode(), bodyVOs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBodyValueVO(String tableCode, CircularlyAccessibleValueObject[] bodyVOs)
/*      */   {
/* 1319 */     getBillListData().setBodyValueVO(tableCode, bodyVOs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setBusiType(String strBusiType)
/*      */   {
/* 1328 */     this.m_strBusiType = strBusiType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setCorp(String strCorp)
/*      */   {
/* 1337 */     this.m_strCorp = strCorp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnabled(boolean newEnabled)
/*      */   {
/* 1344 */     getBillListData().setEnabled(newEnabled);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHeaderValueVO(CircularlyAccessibleValueObject[] headVOs)
/*      */   {
/* 1351 */     getBillListData().setHeaderValueVO(headVOs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setListData(BillListData billTempletData)
/*      */   {
/* 1361 */     this.m_ListData = billTempletData;
/*      */     
/* 1363 */     initParentListPanel();
/* 1364 */     initChildListPanel();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1390 */     adjustSplitPanel();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setListData(BillListData billTempletData, IBillListData ibld)
/*      */   {
/* 1400 */     if (ibld != null)
/* 1401 */       ibld.prepareBillListData(billTempletData);
/* 1402 */     setListData(billTempletData);
/*      */   }
/*      */   
/*      */   private class DefaultBodyRowNOTableSelectdMode implements IBillTableMouseSelectControl {
/*      */     private DefaultBodyRowNOTableSelectdMode() {}
/*      */     
/*      */     public int getClickCountSelect() {
/* 1409 */       return 1;
/*      */     }
/*      */     
/*      */     public boolean isSupportCornerAllSelect() {
/* 1413 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportCtrlSelect() {
/* 1417 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportShiftSelect() {
/* 1421 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private class DefaultBodyTableSelectdMode implements IBillTableMouseSelectControl
/*      */   {
/*      */     private DefaultBodyTableSelectdMode() {}
/*      */     
/*      */     public int getClickCountSelect() {
/* 1430 */       return 2;
/*      */     }
/*      */     
/*      */     public boolean isSupportCornerAllSelect() {
/* 1434 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportCtrlSelect() {
/* 1438 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportShiftSelect() {
/* 1442 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private class DefaultHeadTableRowSelectdMode implements IBillTableMouseSelectControl
/*      */   {
/*      */     private DefaultHeadTableRowSelectdMode() {}
/*      */     
/*      */     public int getClickCountSelect() {
/* 1451 */       return 2;
/*      */     }
/*      */     
/*      */     public boolean isSupportCornerAllSelect() {
/* 1455 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportCtrlSelect() {
/* 1459 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isSupportShiftSelect() {
/* 1463 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private class DefaultHeadRowNOTableRowSelectdMode implements IBillTableMouseSelectControl
/*      */   {
/*      */     private DefaultHeadRowNOTableRowSelectdMode() {}
/*      */     
/*      */     public int getClickCountSelect() {
/* 1472 */       return 1;
/*      */     }
/*      */     
/*      */     public boolean isSupportCornerAllSelect() {
/* 1476 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isSupportCtrlSelect() {
/* 1480 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isSupportShiftSelect() {
/* 1484 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setMultiSelect(boolean bMultiSelect)
/*      */   {
/* 1495 */     this.m_bMultiSelect = bMultiSelect;
/* 1496 */     setParentMultiSelect(bMultiSelect);
/* 1497 */     setChildMultiSelect(bMultiSelect);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setParentMultiSelect(boolean bMultiSelect)
/*      */   {
/* 1507 */     getParentListPanel().setRowSelectdMode(bMultiSelect, true, new DefaultHeadTableRowSelectdMode(), new DefaultHeadRowNOTableRowSelectdMode());
/*      */     
/*      */ 
/*      */ 
/* 1511 */     if (bMultiSelect) {
/* 1512 */       if (getHeadBillModel().getRowStateChangeEventListener() == null) {
/* 1513 */         getHeadBillModel().addRowStateChangeEventListener(new HeadRowStateListener());
/*      */       }
/*      */     } else {
/* 1516 */       getHeadBillModel().removeRowStateChangeEventListener();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setChildMultiSelect(boolean bMultiSelect)
/*      */   {
/* 1546 */     String[] tableCodes = getBodyTableCodes();
/* 1547 */     if ((tableCodes == null) || (tableCodes.length == 0)) {
/* 1548 */       tableCodes = new String[] { getDefaultTableCode() };
/*      */     }
/* 1550 */     for (int i = 0; i < tableCodes.length; i++) {
/* 1551 */       setChildMultiSelect(bMultiSelect, tableCodes[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   private void setChildMultiSelect(boolean bMultiSelect, String tableCode)
/*      */   {
/* 1557 */     BillScrollPane pane = getChildListPanel(tableCode);
/*      */     
/* 1559 */     if (pane == null) {
/* 1560 */       return;
/*      */     }
/*      */     
/* 1563 */     pane.setRowSelectdMode(bMultiSelect, true, new DefaultBodyTableSelectdMode(), new DefaultBodyRowNOTableSelectdMode());
/*      */     
/*      */ 
/*      */ 
/* 1567 */     if (bMultiSelect) {
/* 1568 */       if (getBodyBillModel(tableCode).getRowStateChangeEventListener() == null) {
/* 1569 */         getBodyBillModel(tableCode).addRowStateChangeEventListener(new BodyRowStateListener());
/*      */       }
/*      */       
/* 1572 */       getChildListPanel(tableCode).addTableBodyMenu();
/*      */     } else {
/* 1574 */       getBodyBillModel(tableCode).removeRowStateChangeEventListener();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNodeKey(String newNodeKey)
/*      */   {
/* 1586 */     this.nodeKey = newNodeKey;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOperator(String strOperator)
/*      */   {
/* 1595 */     this.m_strOperator = strOperator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOrientation(int orientation)
/*      */   {
/* 1602 */     getUISplitPane().setOrientation(orientation);
/*      */   }
/*      */   
/*      */   private void setSplitPanelDividerSize()
/*      */   {
/* 1607 */     JSplitPane splitPane = getUISplitPane();
/*      */     
/*      */ 
/* 1610 */     int oldLocation = splitPane.getDividerLocation();
/* 1611 */     int oldsize = splitPane.getDividerSize();
/* 1612 */     boolean oldEnable = splitPane.isEnabled();
/*      */     
/*      */ 
/* 1615 */     int location = -1;
/* 1616 */     int size = -1;
/* 1617 */     boolean enable = false;
/*      */     
/* 1619 */     if ((getParentListPanel().isVisible()) && (getBodyUIPanel().isVisible())) {
/* 1620 */       if (getUISplitPane().getOrientation() == 0) {
/* 1621 */         location = getHeight() / 2;
/*      */       } else {
/* 1623 */         location = getWidth() / 2;
/*      */       }
/*      */       
/* 1626 */       size = 3;
/* 1627 */       enable = true;
/*      */     } else {
/* 1629 */       size = 0;
/* 1630 */       enable = false;
/* 1631 */       if (getParentListPanel().isVisible()) {
/* 1632 */         location = 10000;
/*      */       } else {
/* 1634 */         location = 0;
/*      */       }
/*      */     }
/*      */     
/* 1638 */     if (oldLocation != location)
/* 1639 */       splitPane.setDividerLocation(location);
/* 1640 */     if (oldsize != size)
/* 1641 */       splitPane.setDividerSize(size);
/* 1642 */     if ((enable != oldEnable) && (System.getProperty("java.vm.version").startsWith("1.2")))
/*      */     {
/* 1644 */       splitPane.setEnabled(enable);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void showBodyTableCol(String strKey)
/*      */   {
/* 1662 */     showBodyTableCol(getDefaultTableCode(), strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void showBodyTableCol(String tableCode, String strKey)
/*      */   {
/* 1672 */     getBodyScrollPane(tableCode).showTableCol(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void showHeadTableCol(String strKey)
/*      */   {
/* 1682 */     getParentListPanel().showTableCol(strKey);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void unlockBodyTableCol(String tablecode)
/*      */   {
/* 1689 */     getChildListPanel().unlockTableCol();
/* 1690 */     if ((this.hBodyLockCols != null) && (this.hBodyLockCols.containsKey(tablecode)))
/* 1691 */       this.hBodyLockCols.remove(tablecode);
/*      */   }
/*      */   
/*      */   public HashMap<String, BillItemUISet> getBillCardUISet() {
/* 1695 */     HashMap<String, BillItemUISet> sets = getBillListData().getBillListDataUISet();
/*      */     
/* 1697 */     return sets;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void registerBillKey()
/*      */   {
/* 1705 */     InputMap map = getInputMap(2);
/* 1706 */     ActionMap am = getActionMap();
/*      */     
/* 1708 */     map.put(KeyStroke.getKeyStroke(120, 2, true), "billuiset");
/*      */     
/* 1710 */     am.put("billuiset", new BillListUISetAction(this));
/*      */   }
/*      */   
/*      */ 
/*      */   private UIPanel getHeadPanel()
/*      */   {
/* 1716 */     if (this.m_HeadPanel == null) {
/* 1717 */       this.m_HeadPanel = new UIPanel();
/* 1718 */       this.m_HeadPanel.setLayout(new BorderLayout());
/* 1719 */       this.m_HeadPanel.add(getParentListPanel(), "Center");
/*      */     }
/*      */     
/* 1722 */     return this.m_HeadPanel;
/*      */   }
/*      */   
/*      */   public void addHeadNavigatePanel(JPanel pnl) {
/* 1726 */     if (pnl != null) {
/* 1727 */       getHeadPanel().add(pnl, "South");
/*      */     }
/*      */   }
/*      */ }
