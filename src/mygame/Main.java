package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bounding.BoundingSphere;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.math.Vector3f;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    
    public Spatial ob;
    public Spatial ob1;
    public Spatial ob2;
    public Spatial ob3;
    public Spatial ob4;
    public Spatial ob5;
    public Spatial ob6;
    public Spatial ob7;
    public Spatial ob8;
    public static final Quaternion PITCH090 = new Quaternion().fromAngleAxis(FastMath.PI/2, new Vector3f(1,0,0));

    //Se crea una esfera para Mercurio
    Sphere m = new Sphere(90,90,0.05f,true,true);
    Geometry mercurio = new Geometry("Sphere", m);
    
    //Se crea una esfera para Venus
    Sphere v = new Sphere(90,90,0.07f,true,true);
    Geometry venus = new Geometry("Sphere", v);
    
    //Se crea una esfera para la Tierra
    Sphere t = new Sphere(90,90,0.09f,true,true);
    Geometry tierra = new Geometry("Sphere", t);
    
    //Se crea una esfera para Marte
    Sphere ma = new Sphere(90,90,0.06f,true,true);
    Geometry marte = new Geometry("Sphere", ma);
    
    //Se crea una esfera para Júpiter
    Sphere j = new Sphere(90,90,0.35f,true,true);
    Geometry jupiter = new Geometry("Sphere", j);
    
    //Se crea una esfera para Saturno
    Sphere sa = new Sphere(90,90,0.3f,true,true);
    Geometry saturno = new Geometry("Sphere", sa);
    
    //Se crea una esfera para Urano
    Sphere u = new Sphere(90,90,0.2f,true,true);
    Geometry urano = new Geometry("Sphere", u);
    
    //Se crea una esfera para Neptuno
    Sphere n = new Sphere(90,90,0.1f,true,true);
    Geometry neptuno = new Geometry("Sphere", n);
        
    public static void main(String[] args) {
        //Para la imagen que tendrá el video juego
        AppSettings settings = new AppSettings(true); //Creamos el objeto para controlar las especificaciones
        settings.setTitle("Sistema Solar"); //Cambiamos el nombre de la ventana
        //Integramos una imagen personal a la pantalla de inicio
        settings.setSettingsDialogImage("Interface/sistemaSolar.png");
        //modificar la resolucion
        settings.setResolution(1280,960);
        Main app = new Main();
        app.setSettings(settings); //Aplicamos las especificaciones a la app
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        flyCam.setMoveSpeed(10f);
        
        //Para controlar si se oculta la informacion de los objetos, mallas y sombras
        //setDisplayFps(false);,
        //setDisplayStartView(false);
        
        //El objetivo flayCam esta instanciado por defecto, al extender SimpleApplication
        flyCam.setMoveSpeed(1.8f); //Determinamos que la camara se desplace a una mayor velocidad
        
        //Cambiaremos la ubicación y rotación de la camara para dar la perspectiva que requiere
        cam.setLocation(new Vector3f(0,40,15));
        cam.setRotation(PITCH090);
        
        
        //Se crea una esfera para el Sol
        Sphere s = new Sphere(90,90,1.5f,true,true);
        Geometry sol = new Geometry("Sphere", s);

        Material matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //matSol.setColor("Color", ColorRGBA.Yellow);
        matSol.setTexture("ColorMap", assetManager.loadTexture("Textures/sol-textura.jpg")); //para cambiar la textura del Sol
        sol.setMaterial(matSol);
        
        //Material de Mercurio
        Material matMercurio = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMercurio.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_mercurio.jpg")); 
        mercurio.setMaterial(matMercurio);
        
        //Material de Venus
        Material matVenus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_venus.jpg")); 
        venus.setMaterial(matVenus);
        
        //Material de la Tierra        
        Material matTierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //matTierra.setColor("Color", ColorRGBA.Blue);
        matTierra.setTexture("ColorMap", assetManager.loadTexture("Textures/textura-tierra.jpg")); 
        tierra.setMaterial(matTierra);
        
        //Material de Marte
        Material matMarte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMarte.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_marte.jpg")); 
        marte.setMaterial(matMarte);
        
        //Material Jupiter
        Material matJupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_jupiter.jpg")); 
        jupiter.setMaterial(matJupiter);
        
        //Material de Saturno 
        Material matSaturno = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matSaturno.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_saturno.jpg")); 
        saturno.setMaterial(matSaturno);
        
        //Material de Urano
        Material matUrano = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matUrano.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_urano.jpg")); 
        urano.setMaterial(matUrano);
        
        //Material de Neptuno
        Material matNeptuno = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matNeptuno.setTexture("ColorMap", assetManager.loadTexture("Textures/textura_neptuno.jpg")); 
        neptuno.setMaterial(matNeptuno);
        
        Quaternion roll90 = new Quaternion();
        roll90.fromAngleAxis(-FastMath.HALF_PI,Vector3f.UNIT_X);
      
        //Se rotan todas las esferas 
        sol.rotate(roll90);
        mercurio.rotate(roll90);
        venus.rotate(roll90);
        tierra.rotate(roll90);
        marte.rotate(roll90);
        jupiter.rotate(roll90);
        saturno.rotate(roll90);
        urano.rotate(roll90);
        neptuno.rotate(roll90);
        

        //Se crea un nodo para cada planeta
        Node mercurioN = new Node("mercurio");
        mercurioN.attachChild(mercurio);
        Node venusN = new Node("venus");
        venusN.attachChild(venus);
        Node tierraN = new Node("tierra");
        tierraN.attachChild(tierra);
        Node marteN = new Node("marte");
        marteN.attachChild(marte);
        Node jupiterN = new Node("jupiter");
        jupiterN.attachChild(jupiter);
        Node saturnoN = new Node("saturno");
        saturnoN.attachChild(saturno);
        Node uranoN = new Node("urano");
        uranoN.attachChild(urano);
        Node neptunoN = new Node("neptuno");
        neptunoN.attachChild(neptuno);
        
        
        //Se crea un nodo para meter a los planetas
        Node sistemaSolar = new Node("sistemaSolar");
        sistemaSolar.attachChild(sol);
        sistemaSolar.attachChild(mercurioN);
        sistemaSolar.attachChild(venusN);
        sistemaSolar.attachChild(tierraN);
        sistemaSolar.attachChild(marteN);
        sistemaSolar.attachChild(jupiterN);
        sistemaSolar.attachChild(saturnoN);
        sistemaSolar.attachChild(uranoN);
        sistemaSolar.attachChild(neptunoN);
        
        
        //Se mueve de posición el Sol
       // sol.move(1,0,0);
       
        //Se mueve de posisción cada planeta
        mercurio.move(0,0,2);
        venus.move(0,0,3);
        tierra.move(0,0,4);
        marte.move(0,0,5);
        jupiter.move(0,0,6);
        saturno.move(0,0,7);
        urano.move(0,0,8);
        neptuno.move(0,0,9);
        
        //Se mueve el nodo
        sistemaSolar.move(0,0,0);
        
        rootNode.attachChild(sistemaSolar);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //Para hacer que la tierra gire alrededor del Sol
        if(ob==null && ob1==null){
            System.out.println("No está asignado el objeto");
            ob = rootNode.getChild("sistemaSolar");
            ob1 = rootNode.getChild("mercurio");
            ob2 = rootNode.getChild("venus");
            ob3 = rootNode.getChild("tierra");
            ob4 = rootNode.getChild("marte");
            ob5 = rootNode.getChild("jupiter");
            ob6 = rootNode.getChild("saturno");
            ob7 = rootNode.getChild("urano");
            ob8 = rootNode.getChild("neptuno");
        }
        else{
            ob.rotate(0,tpf,0);
            ob1.rotate(0,tpf/0.5f,0);
            ob2.rotate(0,tpf/1f,0);
            ob3.rotate(0,tpf/1.5f,0);
            ob4.rotate(0,tpf/2f,0);
            ob5.rotate(0,tpf/2.5f,0);
            ob6.rotate(0,tpf/3f,0);
            ob7.rotate(0,tpf/3.5f,0);
            ob8.rotate(0,tpf/4f,0);
            
            mercurio.rotate(0,0,tpf*.1f);
            venus.rotate(0,0,tpf*1.5f);
            tierra.rotate(0,0,tpf*1.6f);
            marte.rotate(0,0,tpf*1.7f);
            jupiter.rotate(0,0,tpf*1.8f);
            saturno.rotate(0,0,tpf*1.9f);
            urano.rotate(0,0,tpf*2f);
            neptuno.rotate(0,0,tpf*2.2f);
            
        }
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
