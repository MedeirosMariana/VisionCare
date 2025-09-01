/**
 * Função responsável por renderizar os cards de serviço.
 */
function createServiceCardElement() {
  const cardExam = serviceCardComponent({
    title: "Exames de Vista",
    subtitle: "Avaliação completa da sua visão com \n equipamentos modernos e profissionais \n especializados",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Consulta gratuita", "Resultado em 30 min", "Prescrição digital"]
  });

  const cardPrescriptionGlasses = serviceCardComponent({
    title: "Óculos de Grau",
    subtitle: "Óculos com estilo e conforto para seu dia a dia universitário",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Lentes antirreflexo", "Modelos variados", "Entrega rápida"]
  });

  const cardSunglasses = serviceCardComponent({
    title: "Óculos de Sol",
    subtitle: "Proteção e estilo em qualquer estação",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Proteção UV", "Design moderno", "Descontos para estudantes"]
  });

  const carduniversityPlans = serviceCardComponent({
    title: "Óculos de Sol",
    subtitle: "Proteção e estilo em qualquer estação",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Proteção UV", "Design moderno", "Descontos para estudantes"]
  });

  const cardExpressServices = serviceCardComponent({
    title: "Óculos de Sol",
    subtitle: "Proteção e estilo em qualquer estação",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Proteção UV", "Design moderno", "Descontos para estudantes"]
  });

  const cardPremiumGuarantee = serviceCardComponent({
    title: "Óculos de Sol",
    subtitle: "Proteção e estilo em qualquer estação",
    iconSrc: "../../../../assets/images/service_card_modal_icon.svg",
    options: ["Proteção UV", "Design moderno", "Descontos para estudantes"]
  });

  document.getElementById("card-exam").appendChild(cardExam);
  document.getElementById("card-prescription-glasses").appendChild(cardPrescriptionGlasses);
  document.getElementById("card-sunglasses").appendChild(cardSunglasses);
  document.getElementById("card-university-plans").appendChild(carduniversityPlans);
  document.getElementById("card-express-services").appendChild(cardExpressServices);
  document.getElementById("card-premium-guarantee").appendChild(cardPremiumGuarantee);
}
