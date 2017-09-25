$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	
	var codigoNegociacao = button.data('codigo');
	var descricaoNegociacao = button.data('mercadoria');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoNegociacao);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a negociação com o produto: <strong>' + descricaoNegociacao + '</strong>?')
});

$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal:',',thousands: '.', allowZero: true});
});