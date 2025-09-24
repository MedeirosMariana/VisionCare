/**
 * Cria um card de universidade como elemento DOM vanilla.
 * Inclui logo, acrônimo, nome, rating, desconto, informações e benefícios.
 * @param {Object} university - Objeto com dados da universidade
 * @returns {HTMLElement} O card completo da universidade
 */
function universityCardComponent(university) {
  // Cria o container principal do card
  const universityCard = document.createElement('div');
  universityCard.className = 'group relative overflow-hidden bg-gradient-to-br from-white to-gray-50 border-0 rounded-lg hover:shadow-2xl transition-all duration-300 hover:-translate-y-2 cursor-pointer';

  // Conteúdo interno do card
  universityCard.innerHTML = `
    <!-- Background Pattern -->
    <div class="absolute top-0 right-0 w-32 h-32 bg-gradient-to-br ${university.color} opacity-10 rounded-full -translate-y-16 translate-x-16"></div>

    <div class="relative p-6 space-y-4">
      
      <!-- Header: Logo, Acrônimo, Rating e Desconto -->
      <div class="flex items-center justify-between">
        <div class="flex items-center space-x-3">
          <div class="text-3xl">${university.logo}</div>
          <div>
            <h3 class="font-bold text-lg text-gray-900">${university.acronym}</h3>
            <div class="flex items-center space-x-1">
              <!-- Rating Estrelas -->
              <svg class="w-4 h-4 text-yellow-400 fill-current" viewBox="0 0 20 20">
                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
              </svg>
              <span class="text-sm text-gray-600">${university.rating}</span>
            </div>
          </div>
        </div>
        <!-- Badge de desconto -->
        <span class="bg-green-600 text-white px-2 py-1 rounded-md text-sm font-bold">
          ${university.discount} OFF
        </span>
      </div>

      <!-- Informações da Universidade -->
      <div>
        <h4 class="text-gray-900 font-semibold mb-3">${university.name}</h4>
        <div class="space-y-2">
          <!-- Número de estudantes -->
          <div class="flex items-center space-x-2">
            <svg class="w-4 h-4 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z"></path>
            </svg>
            <span class="text-sm text-gray-600">${university.students} estudantes</span>
          </div>

          <!-- Localização -->
          <div class="flex items-center space-x-2">
            <svg class="w-4 h-4 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"></path>
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"></path>
            </svg>
            <span class="text-sm text-gray-600">${university.location}</span>
          </div>

          <!-- Parceria ativa -->
          <div class="flex items-center space-x-2">
            <svg class="w-4 h-4 text-blue-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 14l9-5-9-5-9 5 9 5z"></path>
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z"></path>
            </svg>
            <span class="text-sm text-gray-600">Parceria ativa</span>
          </div>
        </div>
      </div>

      <!-- Benefícios da universidade -->
      <div class="pt-4 border-t border-gray-200">
        <p class="text-xs text-gray-600 mb-2">Benefícios inclusos:</p>
        <div class="flex flex-wrap gap-1">
          <span class="bg-gray-200 text-gray-700 px-2 py-1 rounded text-xs">Desconto exclusivo</span>
          <span class="bg-gray-200 text-gray-700 px-2 py-1 rounded text-xs">Parcelamento</span>
          <span class="bg-gray-200 text-gray-700 px-2 py-1 rounded text-xs">Consulta grátis</span>
        </div>
      </div>
    </div>
  `;

  return universityCard;
}
