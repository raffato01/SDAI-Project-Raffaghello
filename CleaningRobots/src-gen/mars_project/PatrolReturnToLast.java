package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class PatrolReturnToLast extends CyclicBehaviour<PatrolAgent> {
  private PatrolAgent __theAgent = (mars_project.PatrolAgent)/*Used as metadata*/null;

  private AgentEnv<PatrolAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public PatrolReturnToLast(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static PatrolReturnToLast __createEmpty(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.PatrolReturnToLast(_agentEnv);
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
   * mars_project.PatrolReturnToLast doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 105
    	 * waitingPercepts = false
    	 */
    	
    	PatrolReturnToLast.this.setWaitingPercepts(false);
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
      	 * Compiled from source statement from line 108 to line 115
      	 * if not waitingPercepts do
      	 *             if ((myX of agent) = (lastX of agent) and (myY of agent) = (lastY of agent)) do
      	 *                 log "r3: Returned to (" + (lastX of agent) as text + "," + (lastY of agent) as text + "). Resuming scan."
      	 *                 deactivate this
      	 *                 activate PatrolGrid
      	 *             else do
      	 *                 waitingPercepts = true
      	 *                 send message request DoMoveTowards(lastX of agent, lastY of agent) to "environment"@
      	 */
      	
      	if( ! PatrolReturnToLast.this.getWaitingPercepts()) {
      		/* 
      		 * Compiled from source statement from line 109 to line 115
      		 * if ((myX of agent) = (lastX of agent) and (myY of agent) = (lastY of agent)) do
      		 *                 log "r3: Returned to (" + (lastX of agent) as text + "," + (lastY of agent) as text + "). Resuming scan."
      		 *                 deactivate this
      		 *                 activate PatrolGrid
      		 *             else do
      		 *                 waitingPercepts = true
      		 *                 send message request DoMoveTowards(lastX of agent, lastY of agent) to "environment"@
      		 */
      		
      		if((java.util.Objects.equals((PatrolReturnToLast.this.getJadescriptAgent().getMyX()), (PatrolReturnToLast.this.getJadescriptAgent().getLastX())) && java.util.Objects.equals((PatrolReturnToLast.this.getJadescriptAgent().getMyY()), (PatrolReturnToLast.this.getJadescriptAgent().getLastY())))) {
      			/* 
      			 * Compiled from source statement at line 110
      			 * log "r3: Returned to (" + (lastX of agent) as text + "," + (lastY of agent) as text + "). Resuming scan."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolReturnToLast.this.getClass().getName(), PatrolReturnToLast.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("r3: Returned to (") + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((PatrolReturnToLast.this.getJadescriptAgent().getLastX()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf(",")) + java.lang.String.valueOf(((java.lang.String) jadescript.util.types.Converter.convert((PatrolReturnToLast.this.getJadescriptAgent().getLastY()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.INTEGER), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT))))) + java.lang.String.valueOf("). Resuming scan.")));
      			
      			/* 
      			 * Compiled from source statement at line 111
      			 * deactivate this
      			 */
      			
      			PatrolReturnToLast.this.deactivate();
      			
      			/* 
      			 * Compiled from source statement at line 112
      			 * activate PatrolGrid
      			 */
      			
      			new mars_project.PatrolGrid(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		}
      		else {
      			/* 
      			 * Compiled from source statement at line 114
      			 * waitingPercepts = true
      			 */
      			
      			PatrolReturnToLast.this.setWaitingPercepts(true);
      			
      			/* 
      			 * Compiled from source statement at line 115
      			 * send message request DoMoveTowards(lastX of agent, lastY of agent) to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent470091008 = mars_project.MarsOntology.DoMoveTowards(PatrolReturnToLast.this.getJadescriptAgent().getLastX() ,PatrolReturnToLast.this.getJadescriptAgent().getLastY());
      				
      				jadescript.core.message.Message _synthesizedMessage470091008 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage470091008.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent470091008,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage470091008.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage470091008.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage470091008, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent470091008, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage470091008);
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

  private PatrolReturnToLast.__Event2 __event2 =  new mars_project.PatrolReturnToLast.__Event2();

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(PatrolReturnToLast.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1494821743 {
      	public java.lang.Integer x;
      	
      	public java.lang.Integer y;
      	
      	public java.lang.Integer rx;
      	
      	public java.lang.Integer ry;
      	
      	public java.lang.Boolean hasGarb;
      	
      	private final __PatternMatcher1494821743 __PatternMatcher1494821743_obj =  this;
      	
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
      __PatternMatcher1494821743 __PatternMatcher1494821743_obj = new __PatternMatcher1494821743();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1494821743_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PatrolReturnToLast.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 118
      			 * waitingPercepts = false
      			 */
      			
      			PatrolReturnToLast.this.setWaitingPercepts(false);
      			
      			/* 
      			 * Compiled from source statement at line 119
      			 * myX of agent = x
      			 */
      			
      			PatrolReturnToLast.this.getJadescriptAgent().setMyX(__PatternMatcher1494821743_obj.x);
      			
      			/* 
      			 * Compiled from source statement at line 120
      			 * myY of agent = y
      			 */
      			
      			PatrolReturnToLast.this.getJadescriptAgent().setMyY(__PatternMatcher1494821743_obj.y);
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

  private PatrolReturnToLast.__Event3 __event3 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PatrolReturnToLast.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	PatrolReturnToLast.this.waitingPercepts = false;
    	
    	__event3 = new mars_project.PatrolReturnToLast.__Event3();
    }
  }
}
