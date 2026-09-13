package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class DeliverToR2 extends CyclicBehaviour<ScannerAgent> {
  private ScannerAgent __theAgent = (mars_project.ScannerAgent)/*Used as metadata*/null;

  private AgentEnv<ScannerAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public DeliverToR2(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static DeliverToR2 __createEmpty(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.DeliverToR2(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event3.run();
    __event4.run();
    __event5.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event3.__eventFired && !__event4.__eventFired && !__event5.__eventFired) __awaitForEvents();
  }

  public Boolean __hasStaleMessageHandler() {
    return false;
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public MarsOntology __ontology__mars_project_MarsOntology = (mars_project.MarsOntology) mars_project.MarsOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(mars_project.MarsOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected Boolean waitingPercepts = null;

  public void setWaitingPercepts(final Boolean waitingPercepts) {
    this.waitingPercepts = waitingPercepts;
  }

  public Boolean getWaitingPercepts() {
    return this.waitingPercepts;
  }

  protected Boolean waitingDrop = null;

  public void setWaitingDrop(final Boolean waitingDrop) {
    this.waitingDrop = waitingDrop;
  }

  public Boolean getWaitingDrop() {
    return this.waitingDrop;
  }

  /**
   * mars_project.DeliverToR2 doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 74
    	 * waitingPercepts = false
    	 */
    	
    	DeliverToR2.this.setWaitingPercepts(false);
    	
    	/* 
    	 * Compiled from source statement at line 75
    	 * waitingDrop = false
    	 */
    	
    	DeliverToR2.this.setWaitingDrop(false);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event3 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 78 to line 84
      	 * if not waitingPercepts and not waitingDrop do
      	 *             if ((myX of agent) = (r2X of agent) and (myY of agent) = (r2Y of agent)) do
      	 *                 waitingDrop = true
      	 *                 send message request DoDrop to "environment"@
      	 *             else do
      	 *                 waitingPercepts = true
      	 *                 send message request DoMoveTowards(r2X of agent, r2Y of agent) to "environment"@
      	 */
      	
      	if( ! DeliverToR2.this.getWaitingPercepts() &&  ! DeliverToR2.this.getWaitingDrop()) {
      		/* 
      		 * Compiled from source statement from line 79 to line 84
      		 * if ((myX of agent) = (r2X of agent) and (myY of agent) = (r2Y of agent)) do
      		 *                 waitingDrop = true
      		 *                 send message request DoDrop to "environment"@
      		 *             else do
      		 *                 waitingPercepts = true
      		 *                 send message request DoMoveTowards(r2X of agent, r2Y of agent) to "environment"@
      		 */
      		
      		if((java.util.Objects.equals((DeliverToR2.this.getJadescriptAgent().getMyX()), (DeliverToR2.this.getJadescriptAgent().getR2X())) && java.util.Objects.equals((DeliverToR2.this.getJadescriptAgent().getMyY()), (DeliverToR2.this.getJadescriptAgent().getR2Y())))) {
      			/* 
      			 * Compiled from source statement at line 80
      			 * waitingDrop = true
      			 */
      			
      			DeliverToR2.this.setWaitingDrop(true);
      			
      			/* 
      			 * Compiled from source statement at line 81
      			 * send message request DoDrop to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1735994819 = mars_project.MarsOntology.DoDrop();
      				
      				jadescript.core.message.Message _synthesizedMessage1735994819 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1735994819.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1735994819,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1735994819.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1735994819.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1735994819, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1735994819, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1735994819);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		else {
      			/* 
      			 * Compiled from source statement at line 83
      			 * waitingPercepts = true
      			 */
      			
      			DeliverToR2.this.setWaitingPercepts(true);
      			
      			/* 
      			 * Compiled from source statement at line 84
      			 * send message request DoMoveTowards(r2X of agent, r2Y of agent) to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent983883931 = mars_project.MarsOntology.DoMoveTowards(DeliverToR2.this.getJadescriptAgent().getR2X() ,DeliverToR2.this.getJadescriptAgent().getR2Y());
      				
      				jadescript.core.message.Message _synthesizedMessage983883931 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage983883931.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent983883931,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage983883931.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage983883931.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage983883931, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent983883931, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage983883931);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      	}
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private DeliverToR2.__Event3 __event3 =  new mars_project.DeliverToR2.__Event3();

  private class __Event4 {
    Boolean __eventFired = false;

    public void run() {
      if(DeliverToR2.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher216411874 {
      	public java.lang.Integer x;
      	
      	public java.lang.Integer y;
      	
      	public java.lang.Integer rx;
      	
      	public java.lang.Integer ry;
      	
      	public java.lang.Boolean hasGarb;
      	
      	private final __PatternMatcher216411874 __PatternMatcher216411874_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		x = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		y = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm2(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		rx = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm3(java.lang.Object __objx) {
      		java.lang.Integer __x;
      		
      		try {
      			if(__objx instanceof java.lang.Integer) {
      				__x = (java.lang.Integer) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		ry = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm4(java.lang.Object __objx) {
      		java.lang.Boolean __x;
      		
      		try {
      			if(__objx instanceof java.lang.Boolean) {
      				__x = (java.lang.Boolean) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		hasGarb = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		mars_project.Percepts __x;
      		
      		try {
      			if(__objx instanceof mars_project.Percepts) {
      				__x = (mars_project.Percepts) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getMyX()) && headerMatch_structterm1(__x.getMyY()) && headerMatch_structterm2(__x.getR2X()) && headerMatch_structterm3(__x.getR2Y()) && headerMatch_structterm4(__x.getHasGarbage());
      	}
      }
      __PatternMatcher216411874 __PatternMatcher216411874_obj = new __PatternMatcher216411874();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher216411874_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	DeliverToR2.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 87
      			 * waitingPercepts = false
      			 */
      			
      			DeliverToR2.this.setWaitingPercepts(false);
      			
      			/* 
      			 * Compiled from source statement at line 88
      			 * myX of agent = x
      			 */
      			
      			DeliverToR2.this.getJadescriptAgent().setMyX(__PatternMatcher216411874_obj.x);
      			
      			/* 
      			 * Compiled from source statement at line 89
      			 * myY of agent = y
      			 */
      			
      			DeliverToR2.this.getJadescriptAgent().setMyY(__PatternMatcher216411874_obj.y);
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private DeliverToR2.__Event4 __event4 = null;

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(DeliverToR2.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1560038789 {
      	private final __PatternMatcher1560038789 __PatternMatcher1560038789_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		mars_project.ActionCompleted __x;
      		
      		try {
      			if(__objx instanceof mars_project.ActionCompleted) {
      				__x = (mars_project.ActionCompleted) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,mars_project.MarsOntology.ActionCompleted());
      	}
      }
      __PatternMatcher1560038789 __PatternMatcher1560038789_obj = new __PatternMatcher1560038789();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1560038789_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	DeliverToR2.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement from line 92 to line 96
      			 * if waitingDrop do
      			 *             log "r1: Garbage delivered to r2. Returning to last position..."
      			 *             waitingDrop = false
      			 *             deactivate this
      			 *             activate ReturnToLast
      			 */
      			
      			if(DeliverToR2.this.getWaitingDrop()) {
      				/* 
      				 * Compiled from source statement at line 93
      				 * log "r1: Garbage delivered to r2. Returning to last position..."
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, DeliverToR2.this.getClass().getName(), DeliverToR2.this, "on inform", java.lang.String.valueOf("r1: Garbage delivered to r2. Returning to last position..."));
      				
      				/* 
      				 * Compiled from source statement at line 94
      				 * waitingDrop = false
      				 */
      				
      				DeliverToR2.this.setWaitingDrop(false);
      				
      				/* 
      				 * Compiled from source statement at line 95
      				 * deactivate this
      				 */
      				
      				DeliverToR2.this.deactivate();
      				
      				/* 
      				 * Compiled from source statement at line 96
      				 * activate ReturnToLast
      				 */
      				
      				new mars_project.ReturnToLast(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      			}
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private DeliverToR2.__Event5 __event5 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(DeliverToR2.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	DeliverToR2.this.waitingPercepts = false;
    	
    	DeliverToR2.this.waitingDrop = false;
    	
    	__event4 = new mars_project.DeliverToR2.__Event4();
    	
    	__event5 = new mars_project.DeliverToR2.__Event5();
    }
  }
}
