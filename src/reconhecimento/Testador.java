/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconhecimento;

import java.io.File;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_face;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createEigenFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createLBPHFaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.resize;

/**
 *
 * @author Wesley
 */
public class Testador {
    public static void main(String[] args){
        int totalAcertos = 0;
        double percentualAcerto = 0;
        double totalConfianca = 0;       
                
        //FaceRecognizer reconhecedor = createEigenFaceRecognizer();
         //FaceRecognizer reconhecedor = createFisherFaceRecognizer();
         FaceRecognizer reconhecedor = createLBPHFaceRecognizer();
        
        
        //reconhecedor.load("src\\recursos\\eigenfacesyale.yml");
       // reconhecedor.load("src\\recursos\\fisherfacesyale.yml");
        reconhecedor.load("src\\recursos\\lbphyale.yml");
        
        File diretorio =  new File("src\\faces\\teste");
        File[] arquivos = diretorio.listFiles();
        
        for (File imagem : arquivos){
            Mat foto = imread(imagem.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
            int classe = Integer.parseInt(imagem.getName().substring(7, 9));
            resize(foto, foto, new opencv_core.Size(160, 160));
        
            IntPointer rotulo = new IntPointer(1);
            DoublePointer confianca = new DoublePointer(1);
            reconhecedor.predict(foto, rotulo, confianca);
            int predicao = rotulo.get(0);
            System.out.println(classe + " foi reconhecido como " + predicao + " - " + confianca.get(0));
            if (classe == predicao){
                totalAcertos++;
                totalConfianca += confianca.get(0);
            }
        }
        percentualAcerto = (totalAcertos / 30.0) * 100;
        totalConfianca = totalConfianca / totalAcertos;
        System.out.println("Percentual de acertos: " + percentualAcerto + "Total: " + totalAcertos);
        System.out.println("Total Confiança: " + totalConfianca);
    }
}
