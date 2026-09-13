package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class ScanGrid extends CyclicBehaviour<ScannerAgent> {
  private ScannerAgent __theAgent = (mars_project.ScannerAgent)/*Used as metadata*/null;

  private AgentEnv<ScannerAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public ScanGrid(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static ScanGrid __createEmpty(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.ScanGrid(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event2.run();
    __event3.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event2.__eventFired && !__event3.__eventFired) __awaitForEvents();
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

  /**
   * mars_project.ScanGrid doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 25
    	 * waitingPercepts = false
    	 */
    	
    	ScanGrid.this.setWaitingPercepts(false);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event2 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 28 to line 30
      	 * if not waitingPercepts do
      	 *             waitingPercepts = true
      	 *             send message request DoNextSlot to "environment"@
      	 */
      	
      	if( ! ScanGrid.this.getWaitingPercepts()) {
      		/* 
      		 * Compiled from source statement at line 29
      		 * waitingPercepts = true
      		 */
      		
      		ScanGrid.this.setWaitingPercepts(true);
      		
      		/* 
      		 * Compiled from source statement at line 30
      		 * send message request DoNextSlot to "environment"@
      		 */
      		
      		try {
      			jadescript.util.SendMessageUtils.validatePerformative("request");
      			
      			java.lang.Object _contentToBeSent1427207358 = mars_project.MarsOntology.DoNextSlot();
      			
      			jadescript.core.message.Message _synthesizedMessage1427207358 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      			
      			_synthesizedMessage1427207358.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1427207358,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      			
      			_synthesizedMessage1427207358.setLanguage(__codec.getName());;
      			
      			_synthesizedMessage1427207358.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      			
      			_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1427207358, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1427207358, "request"));
      			
      			_agentEnv.getAgent().send(_synthesizedMessage1427207358);
      		}
      		catch(java.lang.Throwable _t) {
      			throw jadescript.core.exception.JadescriptException.wrap(_t);
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

  private ScanGrid.__Event2 __event2 =  new mars_project.ScanGrid.__Event2();

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(ScanGrid.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1672512489 {
      	public java.lang.Integer x;
      	
      	public java.lang.Integer y;
      	
      	public java.lang.Integer rx;
      	
      	public java.lang.Integer ry;
      	
      	public java.lang.Boolean hasGarb;
      	
      	private final __PatternMatcher1672512489 __PatternMatcher1672512489_obj =  this;
      	
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
      __PatternMatcher1672512489 __PatternMatcher1672512489_obj = new __PatternMatcher1672512489();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1672512489_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ScanGrid.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 33
      			 * waitingPercepts = false
      			 */
      			
      			ScanGrid.this.setWaitingPercepts(false);
      			
      			/* 
      			 * Compiled from source statement at line 34
      			 * myX of agent = x
      			 */
      			
      			ScanGrid.this.getJadescriptAgent().setMyX(__PatternMatcher1672512489_obj.x);
      			
      			/* 
      			 * Compiled from source statement at line 35
      			 * myY of agent = y
      			 */
      			
      			ScanGrid.this.getJadescriptAgent().setMyY(__PatternMatcher1672512489_obj.y);
      			
      			/* 
      			 * Compiled from source statement at line 36
      			 * r2X of agent = rx
      			 */
      			
      			ScanGrid.this.getJadescriptAgent().setR2X(__PatternMatcher1672512489_obj.rx);
      			
      			/* 
      			 * Compiled from source statement at line 37
      			 * r2Y of agent = ry
      			 */
      			
      			ScanGrid.this.getJadescriptAgent().setR2Y(__PatternMatcher1672512489_obj.ry);
      			
      			/* 
      			 * Compiled from source statement from line 39 to line 47
      			 * if (myY of agent) >= 4 do
      			 *             log "r1: Scan finished."
      			 *             deactivate this
      			 *         else if hasGarb do
      			 *             log "r1: Garbage found at (" + (myX of agent) as text + "," + (myY of agent) as text + ")"
      			 *             lastX of agent = myX of agent
      			 *             lastY of agent = myY of agent
      			 *             deactivate this
      			 *             activate PickGarbage
      			 */
      			
      			if((ScanGrid.this.getJadescriptAgent().getMyY()) >= 4) {
      				/* 
      				 * Compiled from source statement at line 40
      				 * log "r1: Scan finished."
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ScanGrid.this.getClass().getName(), ScanGrid.this, "on inform", java.lang.String.valueOf("r1: Scan finished."));
      				
      				/* 
      				 * Compiled from source statement at line 41
      				 * deactivate this
      				 */
      				
      				ScanGrid.this.deactivate();
      			}
      			else if(__PatternMatcher1672512489_obj.hasGarb) {
      				/* 
      				 * Compiled from source statement at line 43
      				 * log "r1: Garbage found at (" + (myX of agent) as text + "," + (myY of agent) as text + ")"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ScanGrid.this.getClass().getName(), ScanGrid.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("r1: Garbage found at (") + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((ScanGrid.this.getJadescriptAgent().getMyX()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf(",")) + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((ScanGrid.this.getJadescriptAgent().getMyY()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf(")")));
      				
      				/* 
      				 * Compiled from source statement at line 44
      				 * lastX of agent = myX of agent
      				 */
      				
      				ScanGrid.this.getJadescriptAgent().setLastX(ScanGrid.this.getJadescriptAgent().getMyX());
      				
      				/* 
      				 * Compiled from source statement at line 45
      				 * lastY of agent = myY of agent
      				 */
      				
      				ScanGrid.this.getJadescriptAgent().setLastY(ScanGrid.this.getJadescriptAgent().getMyY());
      				
      				/* 
      				 * Compiled from source statement at line 46
      				 * deactivate this
      				 */
      				
      				ScanGrid.this.deactivate();
      				
      				/* 
      				 * Compiled from source statement at line 47
      				 * activate PickGarbage
      				 */
      				
      				new mars_project.PickGarbage(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private ScanGrid.__Event3 __event3 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ScanGrid.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ScanGrid.this.waitingPercepts = false;
    	
    	__event3 = new mars_project.ScanGrid.__Event3();
    }
  }
}
