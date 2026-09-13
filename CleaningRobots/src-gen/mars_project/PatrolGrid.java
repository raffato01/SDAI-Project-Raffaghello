package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class PatrolGrid extends CyclicBehaviour<PatrolAgent> {
  private PatrolAgent __theAgent = (mars_project.PatrolAgent)/*Used as metadata*/null;

  private AgentEnv<PatrolAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public PatrolGrid(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static PatrolGrid __createEmpty(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.PatrolGrid(_agentEnv);
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
   * mars_project.PatrolGrid doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 25
    	 * waitingPercepts = false
    	 */
    	
    	PatrolGrid.this.setWaitingPercepts(false);
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
      	
      	if( ! PatrolGrid.this.getWaitingPercepts()) {
      		/* 
      		 * Compiled from source statement at line 29
      		 * waitingPercepts = true
      		 */
      		
      		PatrolGrid.this.setWaitingPercepts(true);
      		
      		/* 
      		 * Compiled from source statement at line 30
      		 * send message request DoNextSlot to "environment"@
      		 */
      		
      		try {
      			jadescript.util.SendMessageUtils.validatePerformative("request");
      			
      			java.lang.Object _contentToBeSent1501112713 = mars_project.MarsOntology.DoNextSlot();
      			
      			jadescript.core.message.Message _synthesizedMessage1501112713 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      			
      			_synthesizedMessage1501112713.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1501112713,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      			
      			_synthesizedMessage1501112713.setLanguage(__codec.getName());;
      			
      			_synthesizedMessage1501112713.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      			
      			_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1501112713, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1501112713, "request"));
      			
      			_agentEnv.getAgent().send(_synthesizedMessage1501112713);
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

  private PatrolGrid.__Event2 __event2 =  new mars_project.PatrolGrid.__Event2();

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(PatrolGrid.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher891086664 {
      	public java.lang.Integer x;
      	
      	public java.lang.Integer y;
      	
      	public java.lang.Integer rx;
      	
      	public java.lang.Integer ry;
      	
      	public java.lang.Boolean hasGarb;
      	
      	private final __PatternMatcher891086664 __PatternMatcher891086664_obj =  this;
      	
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
      __PatternMatcher891086664 __PatternMatcher891086664_obj = new __PatternMatcher891086664();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher891086664_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PatrolGrid.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 33
      			 * waitingPercepts = false
      			 */
      			
      			PatrolGrid.this.setWaitingPercepts(false);
      			
      			/* 
      			 * Compiled from source statement at line 34
      			 * myX of agent = x
      			 */
      			
      			PatrolGrid.this.getJadescriptAgent().setMyX(__PatternMatcher891086664_obj.x);
      			
      			/* 
      			 * Compiled from source statement at line 35
      			 * myY of agent = y
      			 */
      			
      			PatrolGrid.this.getJadescriptAgent().setMyY(__PatternMatcher891086664_obj.y);
      			
      			/* 
      			 * Compiled from source statement at line 36
      			 * r2X of agent = rx
      			 */
      			
      			PatrolGrid.this.getJadescriptAgent().setR2X(__PatternMatcher891086664_obj.rx);
      			
      			/* 
      			 * Compiled from source statement at line 37
      			 * r2Y of agent = ry
      			 */
      			
      			PatrolGrid.this.getJadescriptAgent().setR2Y(__PatternMatcher891086664_obj.ry);
      			
      			/* 
      			 * Compiled from source statement from line 39 to line 47
      			 * if (myY of agent) >= 7 do
      			 *             log "r3: Scan finished."
      			 *             deactivate this
      			 *         else if hasGarb do
      			 *             log "r3: Garbage found at (" + (myX of agent) as text + "," + (myY of agent) as text + ")"
      			 *             lastX of agent = myX of agent
      			 *             lastY of agent = myY of agent
      			 *             deactivate this
      			 *             activate PatrolPickGarbage
      			 */
      			
      			if((PatrolGrid.this.getJadescriptAgent().getMyY()) >= 7) {
      				/* 
      				 * Compiled from source statement at line 40
      				 * log "r3: Scan finished."
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolGrid.this.getClass().getName(), PatrolGrid.this, "on inform", java.lang.String.valueOf("r3: Scan finished."));
      				
      				/* 
      				 * Compiled from source statement at line 41
      				 * deactivate this
      				 */
      				
      				PatrolGrid.this.deactivate();
      			}
      			else if(__PatternMatcher891086664_obj.hasGarb) {
      				/* 
      				 * Compiled from source statement at line 43
      				 * log "r3: Garbage found at (" + (myX of agent) as text + "," + (myY of agent) as text + ")"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolGrid.this.getClass().getName(), PatrolGrid.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("r3: Garbage found at (") + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((PatrolGrid.this.getJadescriptAgent().getMyX()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf(",")) + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((PatrolGrid.this.getJadescriptAgent().getMyY()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf(")")));
      				
      				/* 
      				 * Compiled from source statement at line 44
      				 * lastX of agent = myX of agent
      				 */
      				
      				PatrolGrid.this.getJadescriptAgent().setLastX(PatrolGrid.this.getJadescriptAgent().getMyX());
      				
      				/* 
      				 * Compiled from source statement at line 45
      				 * lastY of agent = myY of agent
      				 */
      				
      				PatrolGrid.this.getJadescriptAgent().setLastY(PatrolGrid.this.getJadescriptAgent().getMyY());
      				
      				/* 
      				 * Compiled from source statement at line 46
      				 * deactivate this
      				 */
      				
      				PatrolGrid.this.deactivate();
      				
      				/* 
      				 * Compiled from source statement at line 47
      				 * activate PatrolPickGarbage
      				 */
      				
      				new mars_project.PatrolPickGarbage(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private PatrolGrid.__Event3 __event3 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PatrolGrid.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	PatrolGrid.this.waitingPercepts = false;
    	
    	__event3 = new mars_project.PatrolGrid.__Event3();
    }
  }
}
