mvn clean install
docker build -t sbonk8s:1.0 .        #uruchom wczesniej minikube docker-env i wykonaj ostatnie polecenie zeby image zostal wgrany do repo minikube nie lokalnego
docker images

#Uruchamia na docker:
docker run -d -p8081:8080 sbonk8s:1.0          #uruchom na lokalnym docker, nie tym minikube
curl http://localhost:8081/message

#Uruchamia na k8s przez minikube:
minikube start
kubectl create deployment sbonk8s --image=sbonk8s:1.0 --port=8082     <--nie.....
kubectl get deployment
kubectl expose deployment sbonk8s --type=NodePort             <--- tutaj brakuje wystawianego portu!!!
kubectl get service
minikube service sbonk8s --url               <-- to nie dziala!!!!!!!!!!!

minikube image ls --format table
___________




_____________
based on: https://minikube.sigs.k8s.io/docs/start/


#WORKING!!!!!!!!!!

kubectl create deployment sbonk8s --image=sbonk8s:1.0
kubectl expose deployment sbonk8s --type=NodePort --port=8080
minikube service sbonk8s    #WORKING!!!!!!!!!!

SUPER MORE: https://minikube.sigs.k8s.io/docs/tutorials/kubernetes_101/

kubectl scale deployments/sbonk8s --replicas=4
kubectl describe services/sbonk8s


kubectl port-forward service/sbonk8s 9999:8080                      <-- to jest kozackie ;))) bo potem mam do wywolania localhost:PORT
kubectl port-forward service/springboot-k8s-svc 9999:8080                      <-- to jest kozackie ;))) bo potem mam do wywolania localhost:PORT

kubectl port-forward service/springboot-k8s-svc 7080:8080

____________
https://minikube.sigs.k8s.io/docs/tutorials/

______________________
sposob instalacji SB na k8s prze yamle:

kubectl apply -f .\deployment.yaml
kubectl apply -f .\service.yaml

_____________
!!!!!!!!!!!
kubectl proxy

http://localhost:8001/version
http://localhost:8001/api/v1/namespaces/default/pods/sbonk8s-7c9595f466-czsjr


_________

kubectl exec -it webapp-deployment-9fccd564d-lj7x2 -- ls /                 <--- podajemy oczywiscie PODa
kubectl exec --stdin --tty webapp-deployment-9fccd564d-lj7x2 -- /bin/sh

