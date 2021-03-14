from django.db import models
from django.utils.safestring import mark_safe


class Slider(models.Model):
    name = models.CharField(max_length=200, verbose_name="name")
    image = models.ImageField(verbose_name="image", upload_to='slider_main')

    def slider_image(self):
        return mark_safe('<img src="{}" height="50"/>'.format(self.image.url))

    def __str__(self):
        return self.name


