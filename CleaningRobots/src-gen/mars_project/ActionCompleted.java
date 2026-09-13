package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class ActionCompleted implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.ActionCompleted");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof ActionCompleted) {
    	ActionCompleted o = (ActionCompleted) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public ActionCompleted() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_ActionCompleted() {
    return null;
  }
}
