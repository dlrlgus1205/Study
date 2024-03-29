// hooms-N1 [cylSJlzdHM]
(function() {
  $(function() {
    $(".hooms-N1").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".hooms-N1 .contents-swiper", {
        slidesPerView: 1,
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        autoplay: {
          delay: 5000,
        },
        pagination: {
          el: ".hooms-N1 .swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".hooms-N1 .swiper-button-next",
          prevEl: ".hooms-N1 .swiper-button-prev",
        },
      });
      // Swiper Play, Pause Button
      const pauseButton = $block.find('.swiper-button-pause');
      const playButton = $block.find('.swiper-button-play');
      playButton.hide();
      pauseButton.show();
      pauseButton.on('click', function() {
        swiper.autoplay.stop();
        playButton.show();
        pauseButton.hide();
      });
      playButton.on('click', function() {
        swiper.autoplay.start();
        playButton.hide();
        pauseButton.show();
      });
    });
  });
})();
// hooms-N7 [oglSjLzE71]
(function() {
  $(function() {
    $(".hooms-N7").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".hooms-N7 .contents-swiper", {
        slidesPerView: 'auto',
        allowTouchMove: false,
        loop: true,
        pagination: {
          type: "progressbar",
          el: ".hooms-N7 .swiper-pagination",
          clickable: true,
        },
        autoplay: {
          delay: 2500,
        },
        on: {
          slideChange: function() {
            $block.find('.contents-slide').removeClass('contents-price-active');
            const activeIndex = this.activeIndex % this.slides.length;
            $block.find('.contents-slide').eq(activeIndex).addClass('contents-price-active');
          }
        }
      });
    });
  });
})();;
// hooms-N53 [zuLSL8sliZ]
(function() {
  $(function() {
    $(".hooms-contact-N3").each(function() {
      const $block = $(this);
      // Textarea Count
      $block.find("textarea").on("keyup", function() {
        var contactText = $(this).val();
        if (contactText.length == 0 || contactText == "") {
          $block.find(".contact-text-count").text("0");
        } else {
          $block.find(".contact-text-count").text(contactText.length);
        }
        if (contactText.length > 4000) {
          $(this).val($(this).val().substring(0, 4000));
        }
      });
      // File Cancel Button
      $block.find('.contact-form-file').each(function() {
        const $this = $(this);
        $this.find('.fileset-input').on('change', function() {
          $(this).siblings('.fileset-btn-cancel').show();
        });
        $this.find('.fileset-btn-cancel').on('click', function() {
          $(this).siblings('.fileset-input').val('');
          $(this).hide();
        });
      });
    });
  });
})();;
// hooms-N36 [YSLsl96TkR]
(function() {
  $(function() {
    $(".hooms-N36").each(function() {
      const $block = $(this);
      // modalSet
      modalSet(".modalset-dim", "#modalSet1");

      function modalSet(dim, modalSet1) {
        // Modal Show
        $block.find('.modalset-btn').on('click', function() {
          $block.find(modalSet1).addClass('modalset-active');
          $block.find(dim).fadeIn();
        });
        // Modal Hide
        $block.find('.modalset-dim, .modal-close, .btnset-confirm').on('click', function() {
          $block.find(modalSet1).removeClass('modalset-active');
          $block.find(dim).fadeOut();
        });
      };
    });
  });
})();;