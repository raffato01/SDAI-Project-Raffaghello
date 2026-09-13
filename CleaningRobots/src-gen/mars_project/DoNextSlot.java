package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class DoNextSlot implements JadescriptAction {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.DoNextSlot");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof DoNextSlot) {
    	DoNextSlot o = (DoNextSlot) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public DoNextSlot() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_DoNextSlot() {
    return null;
  }
}
