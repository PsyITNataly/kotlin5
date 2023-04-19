import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(
            id = 0,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        )

        val result = WallService.add(post)

        assertEquals(1,result.id)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateTestFalse() {
        val newPost = Post(
            id = 0,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        )

        val result = WallService.update(newPost)

        assertFalse(result)
    }
    //assertEquals(false,result)

    @Test
    fun updateTestTrue() {
        val service = WallService
        service.add(Post(
            id = 1,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        ))
        service.add(Post(
            id = 2,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        ))
        service.add(Post(
            id = 3,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        ))

        val update = Post(
            id = 1,
            likes = Likes(0),
            owenId = 0,
            fromId = 0,
            data = 0,
            replyOwnerId = 0,
            replyPostId = 0,
            copywriter = "No",
            portType = "No"
        )


        val result = service.update(update)

        assertTrue(result)
    }

}