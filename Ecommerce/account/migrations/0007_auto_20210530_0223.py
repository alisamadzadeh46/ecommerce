# Generated by Django 3.1.7 on 2021-05-29 21:53

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('user.account', '0006_auto_20210530_0104'),
    ]

    operations = [
        migrations.RenameField(
            model_name='favorite',
            old_name='user',
            new_name='author',
        ),
    ]
