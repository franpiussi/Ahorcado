package utn.model;

public class Word {

    private String word;
    private Integer id;

    public Word (Integer id,String word){
        this.word = word;
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "'" + word + "'" ;
    }
}
