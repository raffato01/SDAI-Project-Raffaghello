package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class PickFailed implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.PickFailed");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PickFailed) {
    	PickFailed o = (PickFailed) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public PickFailed() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_PickFailed() {
    return null;
  }
}
