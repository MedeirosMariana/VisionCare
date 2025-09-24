/**
 * Cria o card de serviço como elemento DOM vanilla.
 * Inclui ícone, título, descrição, preço, duração, features e botão CTA.
 * @param {Object} service - Objeto com dados do serviço
 * @returns {HTMLElement} O card completo do serviço
 */
function serviceCardComponent(service) {
  // Cria o container principal do card
  const card = document.createElement('div');
  card.className = 'p-8 bg-gradient-card hover:shadow-float transition-all duration-300 hover:shadow-2xl hover:-translate-y-2 cursor-pointer';

  // Badge opcional (ex: "Novo", "Promoção")
  let badgeHTML = '';
  if (service.badge) {
    badgeHTML = `
      <div class="absolute top-4 right-4 bg-gradient-accent text-white px-3 py-1 rounded-full text-xs font-bold" style="background: linear-gradient(to right, #3b82f6, #10b981);">
        ${service.badge}
      </div>
    `;
  }

  // Conteúdo interno do card
  card.innerHTML = `
    ${badgeHTML}

    <div class="space-y-6">

      <!-- Ícone do serviço -->
      <div class="w-20 h-20 rounded-xl bg-blue-100 flex items-center justify-center group-hover:scale-110 transition-transform duration-300">
        ${service.icon}
      </div>

      <!-- Título e descrição -->
      <div>
        <h3 class="text-2xl font-bold text-gray-900 mb-3">${service.title}</h3>
        <p class="text-gray-600 mb-4">${service.description}</p>
      </div>

      <!-- Preço e duração -->
      <div class="flex items-center justify-between text-sm">
        <div class="text-blue-600 font-bold text-lg">${service.price}</div>
        <div class="text-gray-600">${service.duration}</div>
      </div>

      <!-- Features inclusas -->
      <div class="space-y-3">
        <h4 class="font-semibold text-gray-900">Incluso:</h4>
        ${service.features.map((feature) => `
          <div class="flex items-start space-x-3">
            ${getCheckIcon()}
            <span class="text-sm text-gray-900">${feature}</span>
          </div>
        `).join('')}
      </div>

      <!-- Botão CTA (navega para agendar consulta) -->
      <button onclick="navigateTo('src/pages/agendarconsulta.html')"
        class="w-full mt-6 px-6 py-3 bg-gradient-to-r from-blue-600 to-green-600 text-white font-medium rounded-lg hover:shadow-lg transition-all duration-200">
        Solicitar Serviço
      </button>

    </div>
  `;

  // Aplica cor personalizada ao ícone do serviço
  const iconElement = card.querySelector('.w-20.h-20 svg');
  if (iconElement) {
    iconElement.classList.add(service.color);
  }

  return card;
}

/**
 * Ícone de check usado para features do serviço
 * @returns {string} SVG inline do check
 */
function getCheckIcon() {
  return `
    <svg class="w-5 h-5 text-green-600 mt-0.5 flex-shrink-0" fill="none" stroke="currentColor" viewBox="0 0 24 24">
      <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"></path>
    </svg>
  `;
}
