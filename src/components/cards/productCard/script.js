/**
 * Cria o card de produto como elemento DOM vanilla.
 * Inclui imagem, desconto, categoria, título, rating, features, preço e botão CTA.
 * @param {Object} product - Objeto com dados do produto
 * @returns {HTMLElement} Card do produto
 */
function productCardComponent(product) {
  const productCard = document.createElement('div');

  // Classe principal do card
  productCard.className = 'group overflow-hidden border-0 bg-gradient-to-br from-gray-50 to-white rounded-lg hover:shadow-2xl transition-all duration-300 hover:-translate-y-2 cursor-pointer';

  // Conteúdo interno
  productCard.innerHTML = `
    <!-- Imagem e badges -->
    <div class="relative overflow-hidden">
      <img
        src="${product.image}"
        alt="${product.name}"
        class="w-full h-48 object-cover group-hover:scale-110 transition-transform duration-500"
      />
      <div class="absolute top-3 left-3">
        <span class="bg-green-600 text-white px-2 py-1 rounded-md text-sm font-semibold">
          ${product.discount}
        </span>
      </div>
      <div class="absolute top-3 right-3">
        <span class="bg-white/90 text-gray-900 px-2 py-1 rounded-md text-sm border">
          ${product.category}
        </span>
      </div>
    </div>

    <!-- Conteúdo do produto -->
    <div class="p-6 space-y-4">
      <div>
        <h3 class="text-xl font-bold text-gray-900 mb-2">${product.name}</h3>

        <!-- Rating -->
        <div class="flex items-center space-x-2 mb-3">
          <div class="flex items-center">
            ${generateStars(product.rating)}
          </div>
          <span class="text-sm text-gray-600">
            ${product.rating} (${product.reviews} avaliações)
          </span>
        </div>
      </div>

      <!-- Features -->
      <div class="space-y-2">
        ${product.features.map(feature => `
          <div class="flex items-center space-x-2">
            <div class="w-2 h-2 rounded-full bg-gradient-to-r from-blue-600 to-purple-600"></div>
            <span class="text-sm text-gray-600">${feature}</span>
          </div>
        `).join('')}
      </div>

      <!-- Preço e botão -->
      <div class="flex items-center justify-between">
        <div class="space-y-1">
          <div class="flex items-center space-x-2">
            <span class="text-2xl font-bold text-blue-600">${product.price}</span>
            <span class="text-sm text-gray-500 line-through">
              ${product.originalPrice}
            </span>
          </div>
          <p class="text-xs text-gray-500">ou 12x sem juros</p>
        </div>

        <!-- Botão CTA -->
        <button onclick="navigateTo('/src/pages/finalizarcompra.html')" 
          class="bg-gradient-to-r from-blue-600 to-blue-700 text-white px-4 py-2 rounded-lg hover:from-blue-700 hover:to-blue-800 transition-all duration-200 flex items-center space-x-2">
          <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 3h2l.4 2M7 13h10l4-8H5.4m0 0L7 13m0 0l-2.5 5M7 13l2.5 5m0 0L17 18"></path>
          </svg>
          <span>Comprar</span>
        </button>
      </div>
    </div>
  `;

  return productCard;
}

/**
 * Gera estrelas de avaliação como SVGs inline.
 * @param {number} rating - Nota de 0 a 5
 * @returns {string} HTML com 5 estrelas (amarelas preenchidas e cinza vazio)
 */
function generateStars(rating) {
  let stars = '';

  // Loop pelas 5 estrelas
  for (let i = 1; i <= 5; i++) {
    if (i <= Math.floor(rating)) {
      stars += `
        <svg class="w-4 h-4 text-yellow-400 fill-current" viewBox="0 0 20 20">
          <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
        </svg>
      `;
    } else {
      stars += `
        <svg class="w-4 h-4 text-gray-300" fill="currentColor" viewBox="0 0 20 20">
          <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
        </svg>
      `;
    }
  }

  return stars;
}
