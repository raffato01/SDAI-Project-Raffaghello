package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class PickGarbage extends CyclicBehaviour<ScannerAgent> {
  private ScannerAgent __theAgent = (mars_project.ScannerAgent)/*Used as metadata*/null;

  private AgentEnv<ScannerAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public PickGarbage(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static PickGarbage __createEmpty(final AgentEnv<? extends ScannerAgent, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new mars_project.PickGarbage(_agentEnv);
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
   * mars_project.PickGarbage doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 54
    	 * log "r1: Attempting to pick garbage..."
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, PickGarbage.this.getClass().getName(), PickGarbage.this, "on activate", java.lang.String.valueOf("r1: Attempting to pick garbage..."));
    	
    	/* 
    	 * Compiled from source statement at line 55
    	 * send message request DoPick to "environment"@
    	 */
    	
    	try {
    		jadescript.util.SendMessageUtils.validatePerformative("request");
    		
    		java.lang.Object _contentToBeSent1481429412 = mars_project.MarsOntology.DoPick();
    		
    		jadescript.core.message.Message _synthesizedMessage1481429412 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
    		
    		_synthesizedMessage1481429412.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1481429412,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
    		
    		_synthesizedMessage1481429412.setLanguage(__codec.getName());;
    		
    		_synthesizedMessage1481429412.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
    		
    		_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1481429412, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1481429412, "request"));
    		
    		_agentEnv.getAgent().send(_synthesizedMessage1481429412);
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
      if(PickGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1792072549 {
      	private final __PatternMatcher1792072549 __PatternMatcher1792072549_obj =  this;
      	
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
      __PatternMatcher1792072549 __PatternMatcher1792072549_obj = new __PatternMatcher1792072549();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1792072549_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PickGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 58
      			 * log "r1: Garbage picked up! Heading to r2..."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PickGarbage.this.getClass().getName(), PickGarbage.this, "on inform", java.lang.String.valueOf("r1: Garbage picked up! Heading to r2..."));
      			
      			/* 
      			 * Compiled from source statement at line 59
      			 * deactivate this
      			 */
      			
      			PickGarbage.this.deactivate();
      			
      			/* 
      			 * Compiled from source statement at line 60
      			 * activate DeliverToR2
      			 */
      			
      			new mars_project.DeliverToR2(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
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

  private PickGarbage.__Event1 __event1 = null;

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(PickGarbage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1514177427 {
      	private final __PatternMatcher1514177427 __PatternMatcher1514177427_obj =  this;
      	
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
      __PatternMatcher1514177427 __PatternMatcher1514177427_obj = new __PatternMatcher1514177427();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1514177427_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	PickGarbage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 63
      			 * log "r1: Pick failed, retrying..."
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PickGarbage.this.getClass().getName(), PickGarbage.this, "on inform", java.lang.String.valueOf("r1: Pick failed, retrying..."));
      			
      			/* 
      			 * Compiled from source statement at line 64
      			 * send message request DoPick to "environment"@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1788975655 = mars_project.MarsOntology.DoPick();
      				
      				jadescript.core.message.Message _synthesizedMessage1788975655 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1788975655.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1788975655,mars_project.MarsOntology.getInstance(),mars_project.MarsOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1788975655.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1788975655.addReceiver(new jade.core.AID(java.lang.String.valueOf("environment"), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1788975655, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1788975655, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1788975655);
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

  private PickGarbage.__Event2 __event2 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PickGarbage.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	__event1 = new mars_project.PickGarbage.__Event1();
    	
    	__event2 = new mars_project.PickGarbage.__Event2();
    }
  }
}
