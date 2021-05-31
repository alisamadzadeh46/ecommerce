# Generated by Django 3.1.7 on 2021-05-29 22:11

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('user.account', '0008_auto_20210530_0226'),
    ]

    operations = [
        migrations.AlterField(
            model_name='favorite',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='user_favorite', related_query_name='user_favorite', to=settings.AUTH_USER_MODEL),
        ),
    ]
