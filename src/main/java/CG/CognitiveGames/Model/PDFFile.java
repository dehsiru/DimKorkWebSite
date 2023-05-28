package CG.CognitiveGames.Model;

import javax.persistence.*;

@Entity
@Table(name = "pdf_files")
public class PDFFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] file;

    public PDFFile() {
    }

    public PDFFile(byte[] file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
