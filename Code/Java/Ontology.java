package ch.eifr.rdf;


import org.eclipse.rdf4j.common.iteration.Iterations;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.mapdb.DB;


public class Ontology {
	
	private static String namespace = "http://www.semanticweb.org/Ufuk/MiniProjet/Ressources/";
	private static String dboNamespace = "http://dbpedia.org/ontology/";
	
	
	//--------------------------------------------RDFS--------------------------------------------------//
	
	//Class + Property object
	private static IRI 
	
		Person, workFor, 
		Organization,
		Engineer, workOn, lives, calculates,
		Department, located, conduct,
		ProjectManager, responsible,
		PostalAdress, 
		Project, site, cost, state, use,
		DeterminingCost, method,
		Contract,
		Technologies,
		Phase;
	
	//Property data
	private static IRI 
	
		firstname, 
		lastname, 
		secteur, 
		phone, 
		postalCode, 
		locality, 
		id, 
		name, 
		total, 
		currencies, 
		market, 
		type,
		software,
		description,
		version,
		step;
	
	//Individuals
	private static IRI 
		
		mathieu, 
		olivia,
		nyon,
		fribourg,
		lechelles,
		geneve,
		pillettes,
		esplanade,
		price1,
		price2,
		marketPublic,
		marketPrivate,
		revit,
		autocad,
		beforeProject,
		execution,
		environnement,
		structure,
		piero,
		david;
	
	static void buildOntology(Repository rep) {
				
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		
		// IRI Classes and object properties
		Person = f.createIRI(dboNamespace, "Person");
		workFor = f.createIRI(namespace, "workFor");
		
		
		Organization = f.createIRI(dboNamespace, "Organization");
		
		Engineer = f.createIRI(namespace, "Engineer");
		workOn = f.createIRI(namespace, "workOn");
		lives = f.createIRI(namespace, "lives");
		calculates = f.createIRI(namespace, "calculates");
		
		Department = f.createIRI(namespace, "Deparment");
		located = f.createIRI(namespace, "located");
		conduct = f.createIRI(namespace, "conduct");

		
		ProjectManager = f.createIRI(namespace, "ProjectManager");
		responsible = f.createIRI(namespace, "responsible");
		
		
		PostalAdress = f.createIRI(namespace, "PostalAdress");
		
		
		Project = f.createIRI(namespace, "Project");
		site = f.createIRI(namespace, "site");
		cost = f.createIRI(namespace, "cost");
		state = f.createIRI(namespace, "state");
		use = f.createIRI(namespace, "use");
		
		DeterminingCost = f.createIRI(namespace, "DeterminingCost");
		method = f.createIRI(namespace, "method");
		
		Contract = f.createIRI(namespace, "Contact");
	
		
		Technologies = f.createIRI(namespace, "Technologies");
		
		Phase = f.createIRI(namespace, "Phase");
		
		
		//IRI object variables		
		firstname = f.createIRI(namespace, "firstname");
		lastname = f.createIRI(namespace, "lastname");
		secteur = f.createIRI(namespace, "secteur");
		phone = f.createIRI(namespace, "phone");
		postalCode = f.createIRI(namespace, "postalCode");
		locality = f.createIRI(namespace, "locality");
		id = f.createIRI(namespace, "id");
		name = f.createIRI(namespace, "name");
		total = f.createIRI(namespace, "total");
		currencies = f.createIRI(namespace, "currencies");
		market = f.createIRI(namespace, "market");
		type = f.createIRI(namespace, "type");
		software = f.createIRI(namespace, "software");
		description = f.createIRI(namespace, "description");
		version = f.createIRI(namespace, "version");
		step = f.createIRI(namespace, "step");
		
		
		
		//IRI instances	
		mathieu = f.createIRI(namespace, "mathieu"); 
		olivia = f.createIRI(namespace, "olivia");
		nyon = f.createIRI(namespace, "nyon");
		fribourg = f.createIRI(namespace, "fribourg"); 
		lechelles = f.createIRI(namespace, "lechelles");
		geneve = f.createIRI(namespace, "geneve");
		esplanade = f.createIRI(namespace, "esplanade");
		pillettes = f.createIRI(namespace, "pillettes");
		price1 = f.createIRI(namespace, "price1");
		price2 = f.createIRI(namespace, "price2");
		marketPublic = f.createIRI(namespace, "marketPublic");
		marketPrivate= f.createIRI(namespace, "marketPrivate");
		revit = f.createIRI(namespace, "revit");
		autocad = f.createIRI(namespace, "autocad");
		beforeProject = f.createIRI(namespace, "beforeProject");
		execution = f.createIRI(namespace, "execution"); 
		environnement = f.createIRI(namespace, "environnement");
		structure = f.createIRI(namespace, "structure");
		piero = f.createIRI(namespace, "piero");
		david = f.createIRI(namespace, "david");
		
		
		
		try {
			conn.add(Person, RDF.TYPE, RDFS.CLASS);
			conn.add(workFor, RDF.TYPE, RDF.PREDICATE);
			
			conn.add(Organization, RDF.TYPE, RDFS.CLASS);
			
			conn.add(Engineer, RDF.TYPE, RDFS.CLASS);
			conn.add(Engineer, RDFS.SUBCLASSOF, Person);
			conn.add(workOn, RDF.TYPE, RDF.PREDICATE);
			conn.add(lives, RDF.TYPE, RDF.PREDICATE);
			conn.add(calculates, RDFS.SUBPROPERTYOF, workFor);
			conn.add(calculates, RDF.TYPE, RDF.PREDICATE);
			
			conn.add(Department, RDF.TYPE, RDFS.CLASS);
			conn.add(Department, RDFS.SUBCLASSOF, Organization);
			conn.add(located, RDF.TYPE, RDF.PREDICATE);
			conn.add(conduct, RDF.TYPE, RDF.PREDICATE);
			
			
			conn.add(ProjectManager, RDF.TYPE, RDFS.CLASS);
			conn.add(responsible, RDF.TYPE, RDF.PREDICATE);
			
			conn.add(PostalAdress, RDF.TYPE, RDFS.CLASS);
			
			conn.add(Project, RDF.TYPE, RDFS.CLASS);
			conn.add(site, RDF.TYPE, RDF.PREDICATE);
			conn.add(cost, RDF.TYPE, RDF.PREDICATE);
			conn.add(state, RDF.TYPE, RDF.PREDICATE);
			conn.add(use, RDF.TYPE, RDF.PREDICATE);
			
			conn.add(DeterminingCost, RDF.TYPE, RDFS.CLASS);
			conn.add(method, RDF.TYPE, RDF.PREDICATE);

			conn.add(Contract, RDF.TYPE, RDFS.CLASS);
			
			conn.add(Technologies, RDF.TYPE, RDFS.CLASS);
			
			conn.add(Phase, RDF.TYPE, RDFS.CLASS);
					
			
		} finally {
			conn.close();
		}
	}
	
	//--------------------------------------------RDF--------------------------------------------------//
	
	
	static void createIndividualsEngineer (Repository rep, String firstname, String lastname, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Engineer);
			conn.add(iri, RDF.TYPE, Ontology.Person);
			conn.add(iri, Ontology.firstname, f.createLiteral(firstname, XMLSchema.STRING));
			conn.add(iri, Ontology.lastname, f.createLiteral(lastname, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsDepartment(Repository rep, String secteur, String phone, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Department);
			conn.add(iri, Ontology.secteur, f.createLiteral(secteur, XMLSchema.STRING));
			conn.add(iri, Ontology.phone, f.createLiteral(phone, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsProjectManager(Repository rep, String firstname, String lastname, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.ProjectManager);
			conn.add(iri, RDF.TYPE, Ontology.Person);
			conn.add(iri, Ontology.firstname, f.createLiteral(firstname, XMLSchema.STRING));
			conn.add(iri, Ontology.lastname, f.createLiteral(lastname, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsPostalAdress(Repository rep, String postalCode, String locality, IRI iri) {

		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.PostalAdress);
			conn.add(iri, Ontology.postalCode, f.createLiteral(postalCode, XMLSchema.STRING));
			conn.add(iri, Ontology.locality, f.createLiteral(locality, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsProject(Repository rep, String id, String name, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Project);
			conn.add(iri, Ontology.id, f.createLiteral(id, XMLSchema.STRING));
			conn.add(iri, Ontology.name, f.createLiteral(name, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsDeterminingCost(Repository rep, String total, String currencies, IRI iri) {

		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.DeterminingCost);
			conn.add(iri, Ontology.total, f.createLiteral(total, XMLSchema.STRING));
			conn.add(iri, Ontology.currencies, f.createLiteral(currencies, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsContract(Repository rep, String market, String type, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Contract);
			conn.add(iri, Ontology.market, f.createLiteral(market, XMLSchema.STRING));
			conn.add(iri, Ontology.type, f.createLiteral(type, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsTechnologies(Repository rep, String software, String description, IRI iri) {
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Technologies);
			conn.add(iri, Ontology.software, f.createLiteral(software, XMLSchema.STRING));
			conn.add(iri, Ontology.description, f.createLiteral(description, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	static void createIndividualsPhase(Repository rep, String version, String step, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ontology.Phase);
			conn.add(iri, Ontology.version, f.createLiteral(version, XMLSchema.STRING));
			conn.add(iri, Ontology.step, f.createLiteral(step, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}
	
	
	
	
	static void createIndividuals(Repository rep) {

		createIndividualsEngineer(rep, "Mathieu", "Curti", mathieu);
		createIndividualsEngineer(rep, "Olivia", "NGuedia", olivia);
		
		createIndividualsDepartment(rep, "Environnement", "0332568954", environnement);
		createIndividualsDepartment(rep, "Structure", "0262659756", structure);
		
		
		createIndividualsProjectManager(rep, "Piero", "Fonzo", piero);
		createIndividualsProjectManager(rep, "David", "Amsler", david);
		
		createIndividualsPostalAdress(rep, "1260", "Nyon", nyon);
		createIndividualsPostalAdress(rep, "1700", "Fribourg", fribourg);
		createIndividualsPostalAdress(rep, "1773", "LesEchelles", lechelles);
		createIndividualsPostalAdress(rep, "1200", "Genève", geneve);

		createIndividualsProject(rep, "5342", "LesPillettes", pillettes);
		createIndividualsProject(rep, "3903", "TourEsplanade", esplanade);
		
		createIndividualsDeterminingCost(rep, "5000000", "CHF", price1);
		createIndividualsDeterminingCost(rep, "40000000", "CHF", price2);
		
		createIndividualsContract(rep, "Public", "FlateRate", marketPublic);
		createIndividualsContract(rep, "Private", "Unite", marketPrivate);
		
		createIndividualsTechnologies(rep, "Revit", "BIM", revit);
		createIndividualsTechnologies(rep, "Autocad", "2D", autocad);
		
		createIndividualsPhase(rep, "Final", "beforeProject", beforeProject);
		createIndividualsPhase(rep, "Provisional", "execution", execution);
			
	}
	
	static void linkIndividuals(Repository rep) {
		
		// Links between objects
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		
		try {
			conn.add(mathieu, Ontology.workOn, pillettes);
			conn.add(mathieu, Ontology.lives, fribourg);
			conn.add(olivia, Ontology.workOn, esplanade);
			conn.add(olivia, Ontology.lives, lechelles);
			conn.add(olivia, Ontology.calculates, structure);
			
			conn.add(environnement, Ontology.located, nyon);
			conn.add(environnement, Ontology.conduct, pillettes);
			conn.add(structure, Ontology.located, fribourg);
			conn.add(structure, Ontology.conduct, pillettes);
			conn.add(structure, Ontology.conduct, esplanade);
			
			conn.add(piero, Ontology.lives, lechelles);
			conn.add(piero, Ontology.responsible, structure);
			conn.add(david, Ontology.lives, geneve);
			conn.add(david, Ontology.responsible, environnement);
			
			conn.add(pillettes, Ontology.site, nyon);
			conn.add(pillettes, Ontology.cost, price1);
			conn.add(pillettes, Ontology.state, beforeProject);
			conn.add(pillettes, Ontology.use, revit);
			
			conn.add(esplanade, Ontology.site, fribourg);
			conn.add(esplanade, Ontology.cost, price2);
			conn.add(esplanade, Ontology.state, execution);
			conn.add(esplanade, Ontology.use, autocad);
			
			conn.add(price1, Ontology.method, marketPrivate);
			conn.add(price2, Ontology.method, marketPublic);
			
	
	
		} finally {
			conn.close();
		}
	}
	
	static void displayRepositoryTurtleFormat(Repository rep) {
	
		RepositoryConnection conn = rep.getConnection();
		rep.init();
		
		RepositoryResult<Statement> statements = conn.getStatements (null, null, null, true);
		Model model = Iterations.addAll(statements, new LinkedHashModel());	
		
		model.setNamespace("rdf", RDF.NAMESPACE);
		model.setNamespace("rdfs", RDFS.NAMESPACE);
		model.setNamespace("xsd", XMLSchema.NAMESPACE);
		model.setNamespace("foaf", FOAF.NAMESPACE);
		model.setNamespace("ns", namespace);
		model.setNamespace("dbo", dboNamespace);
		
		Rio.write(model, System.out, RDFFormat.TURTLE);
	}
	
	
	
	//--------------------------------------------SPARQL 1.4--------------------------------------------------//
	
static void execQueryGet1(Repository rep) {
		
		RepositoryConnection conn = rep.getConnection();
		try {
			String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
									"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
									"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
									"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
									"PREFIX ns: <" + namespace + ">" +
												
		 							"select distinct ?id ?name ?total where { "+
		 							"?x rdf:type ns:Project . " +  
		 							"?x ns:id ?id . " +
		 							"?x ns:name ?name . " +
		 							"?x ns:cost ?price . " +
		 							"?price ns:total ?total . " +
		 									
		 							"FILTER regex(?total, '40000000')" +
		 									
		 							"}";
					
			TupleQuery query = conn.prepareTupleQuery(queryString);
			try (TupleQueryResult result = query.evaluate()) {			
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?id = " + solution.getValue("id");
					String line2 = "?name = " + solution.getValue("name");
					String line3 = "?total= " + solution.getValue("total");
					System.out.println(line1);
					System.out.println(line2);
					System.out.println(line3);		
				}
			}
		} finally {
				conn.close();
		}
	}

//--------------------------------------------SPARQL 2.4--------------------------------------------------//

static void execQueryGet2(Repository rep) {
	
	RepositoryConnection conn = rep.getConnection();
	try {
		String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
								"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
								"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
								"PREFIX ns: <" + namespace + ">" +
								
								"select distinct ?lastname ?firstname where { "+
								"?x rdf:type dbo:Person . " +  
								"?x ns:lastname ?lastname . " +
								"?x ns:firstname ?firstname . " +
									
								"}"+
								"ORDER BY ?lastname"
								;

			TupleQuery query = conn.prepareTupleQuery(queryString);
			try (TupleQueryResult result = query.evaluate()) {			
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?lastname = " + solution.getValue("lastname");
					String line2 = "?firstname = " + solution.getValue("firstname");
					System.out.println(line1);
					System.out.println(line2);	
			}
		}
	} finally {
			conn.close();
	}
}

//--------------------------------------------SPARQL 3.4--------------------------------------------------//

static void execQueryGet3(Repository rep) {
	
	RepositoryConnection conn = rep.getConnection();
	try {
		String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
								"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
								"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
								"PREFIX ns: <" + namespace + ">" +
								
								
								"select ?lastname where { "+
									
 								"{	?x rdf:type ns:ProjectManager . " + 
 								"?x ns:responsible ns:structure . }" + 
 									
 								"union" +													
 								
 								"{	?x rdf:type ns:ProjectManager . " + 
 								"?x ns:responsible ns:environnement . }" + 
							
								"?x ns:lastname ?lastname . " +
 		
 								"}" ;	
		
			TupleQuery query = conn.prepareTupleQuery(queryString);
			try (TupleQueryResult result = query.evaluate()) {
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?lastname = " + solution.getValue("lastname");
					System.out.println(line1);
			}
		}
	} finally {
			conn.close();
	}
}

//--------------------------------------------SPARQL 4.4--------------------------------------------------//

static void execQueryGet4(Repository rep) {
	
	RepositoryConnection conn = rep.getConnection();
	try {
		String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
								"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
								"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
								"PREFIX ns: <" + namespace + ">" +
								
								"select distinct ?name where { "+
								"?x rdf:type ns:Project . " +  
								"?x ns:name ?name . " +
						
								"OPTIONAL" +
						
								"{ ns:revit ns:use ?x}" +
						
							
								"}";		

			TupleQuery query = conn.prepareTupleQuery(queryString);
			try (TupleQueryResult result = query.evaluate()) {
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?name = " + solution.getValue("name");
					System.out.println(line1);

			}
		}
	} finally {
			conn.close();
	}
}


//--------------------------------------------SPARQL 5.4--------------------------------------------------//

static void execQueryGet5(Repository rep) {
		
		RepositoryConnection conn = rep.getConnection();
		try {
			String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
									"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
									"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
									"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
									"PREFIX ns: <" + namespace + ">" +
					
								 
									"select distinct ?lastname  where { "+
									"?x rdf:type dbo:Person . " +  
									"?x ns:lastname ?lastname . " +
									
									"FILTER regex(?lastname, '^F')" +
								
							
									"}";

			TupleQuery query = conn.prepareTupleQuery(queryString);

			try (TupleQueryResult result = query.evaluate()) {
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?lastname = " + solution.getValue("lastname");
					System.out.println(line1);
				}
			}
		} finally {
			conn.close();
		}
	}



//--------------------------------------------SPARQL 6.4--------------------------------------------------//

static void execQueryGet6(Repository rep) {
	
	RepositoryConnection conn = rep.getConnection();
	try {
		String queryString =	"PREFIX db: <http://dbpedia.org/resource/>" + 
								"PREFIX dbo: <http://dbpedia.org/ontology/>" + 
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
								"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
								"PREFIX ns: <" + namespace + ">" +
								
								"select distinct ?name where { "+
								"?x rdf:type ns:Project . " +  
								"?x ns:name ?name . " +
										
								"}"+
								"LIMIT 1"
								;		

			TupleQuery query = conn.prepareTupleQuery(queryString);	
			try (TupleQueryResult result = query.evaluate()) {
	
				while (result.hasNext()) {
					BindingSet solution = result.next();
					String line1 = "?name = " + solution.getValue("name");
					System.out.println(line1);
			}
		}
	} finally {
			conn.close();
	}
}
		


//--------------------------------------------MAIN--------------------------------------------------//
	
	
	public static void main(String[] args) {
		
		Repository rep = new SailRepository(new MemoryStore());
		
		try {
			buildOntology(rep);
			createIndividuals(rep);
			linkIndividuals(rep);
			execQueryGet1(rep);
			execQueryGet2(rep);
			execQueryGet3(rep);
			execQueryGet4(rep);
			execQueryGet5(rep);
			execQueryGet6(rep);
		} finally {
			
		}	
		

	}


}