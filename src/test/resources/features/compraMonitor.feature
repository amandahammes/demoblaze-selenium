#language: pt
  @Feature
  Funcionalidade: Realizar compra de monitor

    @Cenario1:
    Cenario: compro monitor
      Dado que clico na opção monitores do menu
      E adiciono o monitor o que desejo comprar ao carrinho
      Quando realizar o pagamento
      Então as informações da compra deverão aparecer em tela