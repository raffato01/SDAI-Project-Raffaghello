package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class PatrolPickGarbage extends CyclicBehaviour<PatrolAgent> {
  private PatrolAgent __theAgent = (mars_project.PatrolAgent)/*Used as metadata*/null;

  private AgentEnv<PatrolAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public PatrolPickGarbage(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static PatrolPickGarbage __createEmpty(final AgentEnv<? extends PatrolAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.PatrolPickGarbage(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event1.run();
    __event2.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event1.__eventFired && !__event2.__eventFired) __awaitForEvents();
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

  /**
   * mars_project.PatrolPickGarbage doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 54
    	 * log "r3: Attempting to pick garbage..."
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolPickGarbage.this.getClass().getName(), PatrolPickGarbage.this, "on activate", java.lang.String.valueOf("r3: Attempting to pick garbage..."));
    	
    	/* 
    	 * Compiled from source statement at line 55
    	 * send message request DoPick to "environment"@
    	 */
    	
    	try {
    		jadescript.util.SendMessageUtils.validatePerformative("request");
    		
    		java.lang.Object _contentToBeSent1475772500 = mars_project.MarsOntology.DoPick();
    		
    		jadescript.core.message.Message _synthesizedMessage1475772500 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
    		
    		_synthesizedMessage1475772500.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1475772500,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
    		
    		_synthesizedMessage1475772500.setLanguage(__codec.getName());;
    		
    		_synthesizedMessage1475772500.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
    		
    		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1475772500, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1475772500, "request"));
    		
    		_agentEnv.getAgent().send(_synthesizedMessage1475772500);
    	}
    	catch(java.lang.Throwable _t) {
    		throw jadescript.core.exception.JadescriptException.wrap(_t);
    	}
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event1 {
    Boolean __eventFired = false;

    public void run() {
      if(PatrolPickGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher750301768 {
      	private final __PatternMatcher750301768 __PatternMatcher750301768_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		mars_project.PickedSuccessfully __x;
      		
      		try {
      			if(__objx instanceof mars_project.PickedSuccessfully) {
      				__x = (mars_project.PickedSuccessfully) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,mars_project.MarsOntology.PickedSuccessfully());
      	}
      }
      __PatternMatcher750301768 __PatternMatcher750301768_obj = new __PatternMatcher750301768();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher750301768_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PatrolPickGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 58
      			 * log "r3: Garbage picked up! Heading to r2..."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolPickGarbage.this.getClass().getName(), PatrolPickGarbage.this, "on inform", java.lang.String.valueOf("r3: Garbage picked up! Heading to r2..."));
      			
      			/* 
      			 * Compiled from source statement at line 59
      			 * deactivate this
      			 */
      			
      			PatrolPickGarbage.this.deactivate();
      			
      			/* 
      			 * Compiled from source statement at line 60
      			 * activate PatrolDeliverToR2
      			 */
      			
      			new mars_project.PatrolDeliverToR2(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private PatrolPickGarbage.__Event1 __event1 = null;

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(PatrolPickGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher914519458 {
      	private final __PatternMatcher914519458 __PatternMatcher914519458_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		mars_project.PickFailed __x;
      		
      		try {
      			if(__objx instanceof mars_project.PickFailed) {
      				__x = (mars_project.PickFailed) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,mars_project.MarsOntology.PickFailed());
      	}
      }
      __PatternMatcher914519458 __PatternMatcher914519458_obj = new __PatternMatcher914519458();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher914519458_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PatrolPickGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 63
      			 * log "r3: Pick failed, retrying..."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolPickGarbage.this.getClass().getName(), PatrolPickGarbage.this, "on inform", java.lang.String.valueOf("r3: Pick failed, retrying..."));
      			
      			/* 
      			 * Compiled from source statement at line 64
      			 * send message request DoPick to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1287390578 = mars_project.MarsOntology.DoPick();
      				
      				jadescript.core.message.Message _synthesizedMessage1287390578 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1287390578.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1287390578,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1287390578.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1287390578.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1287390578, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1287390578, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1287390578);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
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

  private PatrolPickGarbage.__Event2 __event2 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PatrolPickGarbage.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event1 = new mars_project.PatrolPickGarbage.__Event1();
    	
    	__event2 = new mars_project.PatrolPickGarbage.__Event2();
    }
  }
}
