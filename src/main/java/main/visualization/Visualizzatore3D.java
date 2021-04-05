package main.visualization;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Classe che gestisce la visualizzazione di un modello 3D
 * @author Daniele Pelizzoni
 */
public class Visualizzatore3D extends Canvas3D {

    private final URL currentModel;
    private SimpleUniverse universe;
    private BranchGroup scene;
    private final float eyeOffset;

    /**
     * Costruttoree degli oggetti di class Visualizzatore 3D
     * @param currentModel url del modello da visualizzare
     * @param width larghezza del canvas
     * @param height altezza del canvas
     */
    public Visualizzatore3D(URL currentModel, int width, int height) {
        super(SimpleUniverse.getPreferredConfiguration());
        this.currentModel = currentModel;
        eyeOffset = 0.03f;
        this.setSize(width, height);
        scene = createScene();
        universe = new SimpleUniverse(this);
        universe.addBranchGraph(scene);
    }

    /**
     * Metodo che inizializza la visualizzazione del modello
     * @return
     */
    public BranchGroup createScene() {
        BranchGroup objRoot = new BranchGroup();
        try{
            Transform3D myTransform3D = new Transform3D();
            myTransform3D.setTranslation(new Vector3f(+0.0f,-0.15f,-3.6f));
            TransformGroup objTrans = new TransformGroup(myTransform3D);
            objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            Transform3D t = new Transform3D();
            TransformGroup tg = new TransformGroup(t);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            objTrans.addChild(tg);
            ObjectFile f = new ObjectFile();
            f.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);

            Background background = new Background(new Color3f(.1f,.1f,.1f));
            BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
            background.setApplicationBounds(sphere);
            tg.addChild(background);

            Scene s = f.load(currentModel);
            Transform3D myTrans = new Transform3D();
            myTrans.setTranslation(new Vector3f(eyeOffset, -eyeOffset, 0F));
            TransformGroup mytg = new TransformGroup(myTrans);

            tg.addChild(mytg);
            Hashtable table = s.getNamedObjects();
            for(Enumeration e = table.keys(); e.hasMoreElements() ;) {
                Object key = e.nextElement();
                Object obj = table.get(key);
                Shape3D shape = (Shape3D)obj;

                Appearance ap = new Appearance();
                Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
                Color3f green = new Color3f(.5f, .5f, .5f);

                ap.setMaterial(new Material(green,black, green, black, 1.0f));
                ap.setRenderingAttributes(new RenderingAttributes());

                shape.setAppearance(ap);
                mytg.addChild(new Shape3D(shape.getGeometry(),ap));
            }

            BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
            Color3f light1Color = new Color3f(.9f, 0.9f, 0.9f);
            Vector3f light1Direction  = new Vector3f(4.0f, -7.0f, -12.0f);
            DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
            light1.setInfluencingBounds(bounds);
            objTrans.addChild(light1);

            Color3f ambientColor = new Color3f(.6f, .6f, 0.6f);
            AmbientLight ambientLightNode = new AmbientLight(ambientColor);
            ambientLightNode.setInfluencingBounds(bounds);
            objTrans.addChild(ambientLightNode);

            MouseRotate behavior = new MouseRotate();
            behavior.setTransformGroup(tg);
            objTrans.addChild(behavior);

            MouseTranslate behavior3 = new MouseTranslate();
            behavior3.setTransformGroup(tg);
            objTrans.addChild(behavior3);
            behavior3.setSchedulingBounds(bounds);

            behavior.setSchedulingBounds(bounds);
            objRoot.addChild(objTrans);
        } catch(Throwable t) {
            t.printStackTrace();
        }
        return objRoot;
    }

}
