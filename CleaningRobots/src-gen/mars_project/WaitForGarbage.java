package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitForGarbage extends CyclicBehaviour<IncineratorAgent> {
  private IncineratorAgent __theAgent = (mars_project.IncineratorAgent)/*Used as metadata*/null;

  private AgentEnv<IncineratorAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public WaitForGarbage(final AgentEnv<? extends IncineratorAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static WaitForGarbage __createEmpty(final AgentEnv<? extends IncineratorAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.WaitForGarbage(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event0.run();
    __event1.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event0.__eventFired && !__event1.__eventFired) __awaitForEvents();
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

  private class __Event0 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitForGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1308506501 {
      	private final __PatternMatcher1308506501 __PatternMatcher1308506501_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		mars_project.GarbageAtBase __x;
      		
      		try {
      			if(__objx instanceof mars_project.GarbageAtBase) {
      				__x = (mars_project.GarbageAtBase) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,mars_project.MarsOntology.GarbageAtBase());
      	}
      }
      __PatternMatcher1308506501 __PatternMatcher1308506501_obj = new __PatternMatcher1308506501();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1308506501_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	WaitForGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 13
      			 * log "r2: Garbage detected at base! Burning..."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForGarbage.this.getClass().getName(), WaitForGarbage.this, "on inform", java.lang.String.valueOf("r2: Garbage detected at base! Burning..."));
      			
      			/* 
      			 * Compiled from source statement at line 14
      			 * send message request DoBurn to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1342257061 = mars_project.MarsOntology.DoBurn();
      				
      				jadescript.core.message.Message _synthesizedMessage1342257061 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1342257061.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1342257061,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1342257061.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1342257061.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1342257061, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1342257061, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1342257061);
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

  private WaitForGarbage.__Event0 __event0 = null;

  private class __Event1 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitForGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1212804079 {
      	private final __PatternMatcher1212804079 __PatternMatcher1212804079_obj =  this;
      	
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
      __PatternMatcher1212804079 __PatternMatcher1212804079_obj = new __PatternMatcher1212804079();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1212804079_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	WaitForGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 17
      			 * log "r2: Garbage burned successfully!"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitForGarbage.this.getClass().getName(), WaitForGarbage.this, "on inform", java.lang.String.valueOf("r2: Garbage burned successfully!"));
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

  private WaitForGarbage.__Event1 __event1 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitForGarbage.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event0 = new mars_project.WaitForGarbage.__Event0();
    	
    	__event1 = new mars_project.WaitForGarbage.__Event1();
    }
  }
}
