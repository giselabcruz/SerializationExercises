package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.example.model.Movie;
import org.example.model.Session;
import org.example.model.Theater;

import java.io.*;

public class SerializationExercises {

    public static class Exercise1 {

        public static void main(String[] args) throws IOException {
            Movie titanic = new Movie("Titanic", 195);
            Movie avatar = new Movie("Avatar", 178);

            Theater cinesa = new Theater("Cinesa", "Madrid");
            Theater metropolis = new Theater("Metrópolis", "Las Palmas");

            Session session1 = new Session(titanic, cinesa, 19.00);
            Session session2 = new Session(avatar, metropolis, 18.00);

            Gson gson = new Gson();

            try (FileWriter writer = new FileWriter("titanic.json")) {
                gson.toJson(titanic, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter("avatar.json")) {
                gson.toJson(avatar, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter("cinesa.json")) {
                gson.toJson(cinesa, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter("metropolis.json")) {
                gson.toJson(metropolis, writer);
            } catch (IOException e) {
                e.printStackTrace();

            }

            try (FileWriter writer = new FileWriter("session1.json")) {
                gson.toJson(session1, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter("session2.json")) {
                gson.toJson(session2, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static class Exercise2 {

            public static void main(String[] args) {
                Gson gson = new Gson();

                Movie deserializedMovie1 = null;
                try (FileReader reader = new FileReader("titanic.json")) {
                    deserializedMovie1 = gson.fromJson(reader, Movie.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Movie deserializedMovie2 = null;
                try (FileReader reader = new FileReader("avatar.json")) {
                    deserializedMovie2 = gson.fromJson(reader, Movie.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Theater deserializedTheater1 = null;
                try (FileReader reader = new FileReader("cinesa.json")) {
                    deserializedTheater1 = gson.fromJson(reader, Theater.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Theater deserializedTheater2 = null;
                try (FileReader reader = new FileReader("metropolis.json")) {
                    deserializedTheater2 = gson.fromJson(reader, Theater.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Session deserializedSession1 = null;
                try (FileReader reader = new FileReader("session1.json")) {
                    deserializedSession1 = gson.fromJson(reader, Session.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Session deserializedSession2 = null;
                try (FileReader reader = new FileReader("session2.json")) {
                    deserializedSession2 = gson.fromJson(reader, Session.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                serializeObject("titanic.bin", deserializedMovie1);
                serializeObject("avatar.bin", deserializedMovie2);
                serializeObject("cinesa.bin", deserializedTheater1);
                serializeObject("metropolis.bin", deserializedTheater2);
                serializeObject("session1.bin", deserializedSession1);
                serializeObject("session2.bin", deserializedSession2);
            }

            private static void serializeObject(String filename, Serializable object) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(object);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


        public static class Exercise3 {

            public static void main(String args[]) throws IOException, ClassNotFoundException {
                Movie deserializedMovie1 = deserializeObject("titanic.bin", Movie.class);
                Movie deserializedMovie2 = deserializeObject("avatar.bin", Movie.class);
                Theater deserializedTheater1 = deserializeObject("cinesa.bin", Theater.class);
                Theater deserializedTheater2 = deserializeObject("metropolis.bin", Theater.class);
                Session deserializedSession1 = deserializeObject("session1.bin", Session.class);
                Session deserializedSession2 = deserializeObject("session2.bin", Session.class);
            }

            private static <T> T deserializeObject(String filename, Class<T> classType) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    return classType.cast(ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}