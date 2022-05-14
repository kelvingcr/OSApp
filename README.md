## Opa tudo bom pessoal? estava um pouco sumido por que estava terminando um curso de kotlin =D, finalizei e tentei colocar em pratica o que eu aprendi.


### 📌 O curso abordou bastante:


Boas práticas, Padrão MVVM, Room, API e Retrofit


Acabando o curso eu resolvi colocar em prática!

Criei um aplicativo utilizando uma API que eu tinha feito usando SpringBoot!


### Como funciona a API?


Basicamente é um sistema de Ordens de Serviço, a API te possibilita a criação de novos clientes, técnicos e ordens de serviço


Dentro da API, há bastante verificação, ontem eu utilizo bastante no aplicativo, Por exemplo se o CPF já existe, a api retorna uma mensagem informando.


### O que eu fiz no aplicativo?


Utilizei a biblioteca do retrofit que facilita muito o consumo de API'S, Juntamente com o gson

Peguei todos os técnicos, clientes e OS, joguei no RecyclerView.

No aplicativo eu implementei um CRUD para técnico e cliente!

é basicamente isso.


Algumas validações da API:


Se já existe o CPF

Se o técnico ou cliente possui uma ordem de serviço não é possivel deletar

Cpf invalido

Validação de campos.



