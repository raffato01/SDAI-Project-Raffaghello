package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class GarbageAtBase implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.GarbageAtBase");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof GarbageAtBase) {
    	GarbageAtBase o = (GarbageAtBase) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public GarbageAtBase() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_GarbageAtBase() {
    return null;
  }
}
