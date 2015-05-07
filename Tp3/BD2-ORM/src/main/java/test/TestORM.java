package test;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import polytech.bd2.Membre;
import polytech.bd2.Salle;
/**
*
* @author elghazel
*/


        
public class TestORM extends TestCase {
    private EntityManager em;
    protected EntityManager createEntityManager() {
    return
    Persistence.createEntityManagerFactory("bd2_polytech_oracle").createEntityManager();
    }
    
   
    public void testOracle() {
        EntityManager em = Persistence.createEntityManagerFactory("bd2_polytech_oracle").createEntityManager();
        em.close();
    }
    @Override
    protected void setUp() throws Exception {
        if (em == null) {
            em = createEntityManager();
        }
        em.getTransaction().begin();
    }
    @Override
    protected void tearDown() throws Exception {
        em.getTransaction().rollback();
    }
     public void testOperationsVariees() {
        Membre m = createMembre("Sting", "sting@police.com");
        assertNotNull(m);
        Membre m2 = getMembre(m.getId());
        assertEquals(m,m2);

        assertTrue(m==m2);
        if(m.getId()==m2.getId()) {
            System.out.println("dffd");
        }
    
        
    Salle s = createSalle("Synchronicity", m);
    assertNotNull(s);
    Salle s2 = getSalle(s.getId());
    assertEquals(s,s2);
    assertTrue(s==s2);
    assertEquals(1,m.getSallesdumoderateur().size());
    int sId = s.getId();
    supprimeSalle(sId);
    assertNull(getSalle(sId));
    int mId = m.getId();
    supprimeMembre(mId);
    assertNull(getMembre(mId));
    m = createMembre("Peter Gabriel", "peter@secretworld.org");
    s = createSalle("Live", m);
    mId = m.getId();
    sId = s.getId();
    supprimeSalle(s);
    supprimeMembre(m);
    assertNull(getSalle(sId));
    assertNull(getMembre(mId));
    }
     
    public  Salle createSalle(String nom, Membre m){
        Salle s = new Salle();
        s.setTitre(nom);
        s.setModerateur(m);
        em.persist(s);
        return s;
     }
    
    public Membre createMembre(String nom,String mail){
        Membre m = new Membre();
        m.setNom(nom);
        m.setEmail(mail);
        em.persist(m);
        return m;
    }
    public Salle getSalle(int id){
        return em.find(Salle.class,id);
    }
    
    public Membre getMembre(int id){
        return em.find(Membre.class,id);
    }
    
    
    
    public void supprimeSalle(Salle s){
        em.remove(s);
    }
    
    public void supprimeSalle(int id){
        em.remove(id);
    }
    
    public void supprimeMembre(Membre m){
        em.remove(m);
    }
    
    public void supprimeMembre(int id ){
        em.remove(id);
    }
 }

