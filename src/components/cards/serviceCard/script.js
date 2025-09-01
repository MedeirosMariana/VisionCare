/**
 * Função responsável por exibir um card de serviço do sistema.
 * @param title Título do card.
 * @param subTitle Sub título do card.
 * @param iconSrc Caminho do card.
 * @param options Opções a serem renderizadas.
 * @returns html do card.
 */
function serviceCardComponent({ title, subtitle, iconSrc, options = [] }) {
  const div = document.createElement("div");
  div.className = "service-card-container";

  // Criar lista de opções dinamicamente
  const optionsHTML = options.map(option => `
    <li class="service-card-options-item">
      <span class="custom-bullet"></span>
      ${option}
    </li>
  `).join("");

  // Montar o HTML principal
  div.innerHTML = `
    <div class="service-card-content">
      <div class="service-card-icon">
        <img src="${iconSrc}" alt="Ícone do serviço" />
      </div>

      <div class="service-card-text">
        <span class="service-card-text-title">${title}</span>
        <span class="service-card-text-subtitle">${subtitle}</span>
      </div>
    </div>

    <ul class="service-card-options">
      ${optionsHTML}
    </ul>
  `;

  return div;
}
