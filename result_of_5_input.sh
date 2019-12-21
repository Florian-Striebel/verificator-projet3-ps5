cd ../ps5-projet3-1920-stormbreakers
cat input_files/input1.in | mvn exec:java@run > ../verificator-projet3-ps5/resultat/Result_input1.txt
rm ../verificator-projet3-ps5/resultat/finalFileInput1.in
cat input_files/input1.in ../verificator-projet3-ps5/resultat/Result_input1.txt >> ../verificator-projet3-ps5/resultat/finalFileInput1.in
cd ../verificator-projet3-ps5/src
find src *.java | xargs -i javac -d bin {}
cd ../bin
java fr.unice.polytech.main.VerificatorMain<../resultat/finalFileInput1.in
cd ../../ps5-projet3-1920-stormbreakers

cd ../ps5-projet3-1920-stormbreakers
cat input_files/input2.in | mvn exec:java@run > ../verificator-projet3-ps5/resultat/Result_input2.txt
rm ../verificator-projet3-ps5/resultat/finalFileInput2.in
cat input_files/input2.in ../verificator-projet3-ps5/resultat/Result_input2.txt >> ../verificator-projet3-ps5/resultat/finalFileInput2.in
cd ../verificator-projet3-ps5/src
find src *.java | xargs -i javac -d bin {}
cd ../bin
java fr.unice.polytech.main.VerificatorMain<../resultat/finalFileInput2.in
cd ../../ps5-projet3-1920-stormbreakers


cd ../ps5-projet3-1920-stormbreakers
cat input_files/input3.in | mvn exec:java@run > ../verificator-projet3-ps5/resultat/Result_input3.txt
rm ../verificator-projet3-ps5/resultat/finalFileInput3.in
cat input_files/input3.in ../verificator-projet3-ps5/resultat/Result_input3.txt >> ../verificator-projet3-ps5/resultat/finalFileInput3.in
cd ../verificator-projet3-ps5/src
find src *.java | xargs -i javac -d bin {}
cd ../bin
java fr.unice.polytech.main.VerificatorMain<../resultat/finalFileInput3.in
cd ../../ps5-projet3-1920-stormbreakers

cd ../ps5-projet3-1920-stormbreakers
cat input_files/input4.in | mvn exec:java@run > ../verificator-projet3-ps5/resultat/Result_input4.txt
rm ../verificator-projet3-ps5/resultat/finalFileInput4.in
cat input_files/input4.in ../verificator-projet3-ps5/resultat/Result_input4.txt >> ../verificator-projet3-ps5/resultat/finalFileInput4.in
cd ../verificator-projet3-ps5/src
find src *.java | xargs -i javac -d bin {}
cd ../bin
java fr.unice.polytech.main.VerificatorMain<../resultat/finalFileInput4.in
cd ../../ps5-projet3-1920-stormbreakers

cd ../ps5-projet3-1920-stormbreakers
cat input_files/input5.in | mvn exec:java@run > ../verificator-projet3-ps5/resultat/Result_input5.txt
rm ../verificator-projet3-ps5/resultat/finalFileInput5.in
cat input_files/input5.in ../verificator-projet3-ps5/resultat/Result_input5.txt >> ../verificator-projet3-ps5/resultat/finalFileInput5.in
cd ../verificator-projet3-ps5/src
find src *.java | xargs -i javac -d bin {}
cd ../bin
java fr.unice.polytech.main.VerificatorMain<../resultat/finalFileInput5.in
cd ../../ps5-projet3-1920-stormbreakers
#cat input_files/input3.in | mvn exec:java > ../Verificator/resultat/Result_input3.txt
#cat input_files/input3.in ../Verificator/resultat/Result_input3.txt >> ../Verificator/resultat/finalFileInput3.in
#cat input_files/input4.in | mvn exec:java > ../Verificator/resultat/Result_input4.txt
#cat input_files/input4.in ../Verificator/resultat/Result_input4.txt >> ../Verificator/resultat/finalFileInput4.in
#cat input_files/input5.in | mvn exec:java > ../Verificator/resultat/Result_input5.txt
#cat input_files/input5.in ../Verificator/resultat/Result_input5.txt >> ../Verificator/resultat/finalFileInput5.in
